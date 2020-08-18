package P7_Util;
/**
 * 
 * @author	: 오대근
 * @date	: 2019. 5. 9.
 * @time	: 오후 2:15:50
 * @content	: SHA256기본타입에 소금값 첨가
 *
 */
public class SHA256Salt extends SHA256 {
	public SHA256Salt() {
		super.setSALT("172c3d4795ad2d668d6061c0bde99374915b51b3c609f0b38dc7202ad9833b9f"); // SHA256를 상속받아 소금값 삽입
	}
}
