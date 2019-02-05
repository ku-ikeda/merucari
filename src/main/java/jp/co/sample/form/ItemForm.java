package jp.co.sample.form;

import javax.validation.constraints.NotEmpty;

/**
 * 商品情報を受け取るフォーム.
 * 
 * @author yuta.ikeda
 *
 */
public class ItemForm {

	/** 商品のID */
	private String id;
	/** 商品の名前 */
	@NotEmpty(message="商品名を入力してください")
	private String name;
	/** 商品の状態ID */
	private String condition;
	/** 商品のカテゴリーID */
	private String category;
	/** 商品のブランド */
	private String brand;
	/** 商品の料金 */
	private String price;
	/** 商品の説明 */
	@NotEmpty(message="商品の説明を入力してください")
	private String description;
	/** 親カテゴリーの名前 */
	private String parentId;
	/** 子カテゴリーの名前 */
	private String childId;
	/** 孫カテゴリーの名前 */
	private String grandChildId;

	@Override
	public String toString() {
		return "ItemForm [id=" + id + ", name=" + name + ", condition=" + condition + ", category=" + category
				+ ", brand=" + brand + ", price=" + price + ", description=" + description + ", parentId=" + parentId
				+ ", childId=" + childId + ", grandChildId=" + grandChildId + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getGrandChildId() {
		return grandChildId;
	}

	public void setGrandChildId(String grandChildId) {
		this.grandChildId = grandChildId;
	}
	
}
