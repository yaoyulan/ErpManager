package controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.Pager;
import pojo.Storage;
import service.StorageService;
import tools.CodeTool;

@Controller
public class IndexController {

	@Autowired
	private StorageService storageService;

	/*显示页面*/
	@RequestMapping("/storage.html")
	public String showIndex(Model model){
	    model.addAttribute("currentNo",CodeTool.getCode(storageService.getLastCode()));
		return "storage";

	}
	//刷新编号
    @RequestMapping("/flahNo.do")
    @ResponseBody
    public Object flahNo(Model model){
	    return JSON.toJSONString(CodeTool.getCode(storageService.getLastCode()));
    }


	/*添加商品*/
	@RequestMapping("/addStorage.do")
	@ResponseBody
	public Object addStorage(Storage storage){
		int addFlagNum=0;
		if (storage!=null){
            addFlagNum=storageService.addStorage(storage);
		}
		return JSON.toJSONString(addFlagNum);

	}
    //判断商品名称是否已经存在
	@RequestMapping("/isExistCommodityName.do")
	@ResponseBody
	public Object isExistCommodityName(@RequestParam(required = false) String name){

		return JSON.toJSONString(storageService.isExistCommodityName(name));

	}

    //分页
	@RequestMapping("/pagerShowList.do")
	@ResponseBody
	public ModelAndView pagerShowList(ModelAndView modelAndView, Pager pager){
        System.out.println("---------------------------");
	    modelAndView.setViewName("list");//设置名称为list
		pager.setTotalCount(storageService.getStorageCount());//得到总记录数
		pager.setPageSize(3);//设置页面的大小
		pager.count();//格式化数据（数据的设置都在这个方法里）
		pager.setList(storageService.getStorage(pager));//每页显示的信息集合


		modelAndView.addObject("pager",pager);

		return modelAndView;

	}

    @RequestMapping("/showInfo.do")
    @ResponseBody
    public Object showInfo(Pager pager){
       /* System.out.println(id);
        pager.setId(id);*/
        pager.setTotalCount(storageService.getStorageCount());//得到总记录数
        pager.setPageSize(3);//设置页面的大小
        pager.count();//格式化数据（数据的设置都在这个方法里）
        System.out.println("---------------------------");
        List lists=storageService.getStorage(pager);//每页显示的信息集合
        System.out.println("---------------------------");
        return JSON.toJSONString(lists);

    }


}
