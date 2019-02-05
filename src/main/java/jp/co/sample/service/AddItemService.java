package jp.co.sample.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.domain.Item;
import jp.co.sample.form.ItemForm;
import jp.co.sample.repository.ItemRepository;

@Service
public class AddItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	
	/**
	 * 商品情報を追加する.
	 * 
	 * @param itemForm 商品登録用フォームに入力された情報
	 */
	public void addItem(ItemForm itemForm) {
		
		Item item = new Item();
		BeanUtils.copyProperties(itemForm, item);
		
		item.setCategory(Integer.parseInt(itemForm.getGrandChildId()));
		item.setShipping(0);
		item.setPrice(Integer.parseInt(itemForm.getPrice()));
		item.setCondition(Integer.parseInt(itemForm.getCondition()));
		
		itemRepository.save(item);
		
	}
	
}
