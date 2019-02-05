package jp.co.sample.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.domain.Item;
import jp.co.sample.form.ItemForm;
import jp.co.sample.repository.ItemRepository;

@Service
public class EditItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 商品情報を更新する.
	 * 
	 * @param itemForm
	 */
	public void update(ItemForm itemForm) {
		
		Item item = new Item();
		BeanUtils.copyProperties(itemForm, item);
		
		item.setCategory(Integer.parseInt(itemForm.getGrandChildId()));
		
		itemRepository.updata(item);
		
	}
	
}
