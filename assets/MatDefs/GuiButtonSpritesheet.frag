uniform sampler2D m_ColorMap;

uniform float m_BorderWidth;
uniform vec2 m_ImageSize;
uniform vec2 m_ButtonSize;

varying vec2 texCoord;

void main() {
    
    // Determine tex coords
    vec2 buttonCoord = texCoord * m_ButtonSize;
    vec2 drawTexCoord = vec2(0);
    if (buttonCoord.x <= m_BorderWidth) {
        // Left border
        drawTexCoord.x = texCoord.x * m_ButtonSize.x / m_ImageSize.x;
    } else if (buttonCoord.x > m_ButtonSize.x - m_BorderWidth) {
        // Right border
        drawTexCoord.x = 1.0 - (1.0 - texCoord.x) * m_ButtonSize.x / m_ImageSize.x;
    } else {
        // Middle section
        drawTexCoord.x = (mod(texCoord.x * m_ButtonSize.x - m_BorderWidth, m_ImageSize.x - 2.0 * m_BorderWidth) + m_BorderWidth) / m_ImageSize.x;
    }
    if (buttonCoord.y <= m_BorderWidth) {
        // Bottom border
        drawTexCoord.y = texCoord.y * m_ButtonSize.y / m_ImageSize.y;
    } else if (buttonCoord.y > m_ButtonSize.y - m_BorderWidth) {
        // Top border
        drawTexCoord.y = 1.0 - (1.0 - texCoord.y) * m_ButtonSize.y / m_ImageSize.y;
    } else {
        // Middle section
        drawTexCoord.y = (mod(texCoord.y * m_ButtonSize.y - m_BorderWidth, m_ImageSize.y - 2.0 * m_BorderWidth) + m_BorderWidth) / m_ImageSize.y;
    }
    gl_FragColor = texture2D(m_ColorMap, drawTexCoord);
}
