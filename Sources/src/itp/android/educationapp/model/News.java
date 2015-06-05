package itp.android.educationapp.model;

public class News {
	private int id, position, url_image;
	private String name, content,  created_at;

	public News(int id, String name, String content, int url_image,
			int position, String created_at) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.url_image = url_image;
		this.position = position;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUrl_image() {
		return url_image;
	}

	public void setUrl_image(int url_image) {
		this.url_image = url_image;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
