package itp.android.educationapp.model;

public class NavDrawer {

	private String text;
	private int icon;
	// boolean to set visiblity of the Title
	private boolean isTitle = false, isFinal = false;
	String title;

	public NavDrawer() {
	}

	public NavDrawer(String text, int icon, boolean isFinal) {
		this.text = text;
		this.icon = icon;
		this.isFinal = isFinal;
	}

	public NavDrawer(String text, int icon, boolean isTitle, String title) {
		this.text = text;
		this.icon = icon;
		this.isTitle = isTitle;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public boolean isTitle() {
		return isTitle;
	}

	public void setTitle(boolean isTitle) {
		this.isTitle = isTitle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

}
