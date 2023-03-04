package qlsv;

public class SinhVien {
	private String id;
	private String name;
	private String dob;
	private Double mark;
	
	public static class Builder {
		private String id = "";
		private String name = "";
		private String dob = "";
		private Double mark = 0.0;
		
		public Builder() {
			
		}
		
		public Builder id(String val) {
			this.id = val;
			return this;
		}
		
		public Builder name(String val) {
			this.name = val;
			return this;
		}
		
		public Builder dob(String val) {
			this.dob = val;
			return this;
		}
		
		public Builder mark(Double val) {
			this.mark = val;
			return this;
		}
		
		public SinhVien build() {
			return new SinhVien(this);
		}
	}
	
	private SinhVien(Builder builder) {
		this.id 	= builder.id;
		this.name 	= builder.name;
		this.dob 	= builder.dob;
		this.mark 	= builder.mark;
	}
		
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public Double getMark() {
		return mark;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + dob + " " + mark;
		
	}
	
	
}
