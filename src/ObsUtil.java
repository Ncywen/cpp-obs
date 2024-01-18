/*
*---混淆加密类---
*[Auther]wan
*[QQ]3609272496
*/
package top.wan.cppobs;
import java.util.*;
public class ObsUtil
{
//C++字符串加密
	public String enc_str(String oc,String STR_KEY)
	{
		int AI=wan.getAI(oc);
		String AC=wan.getAC(oc, AI);
		String NAC=wan.getNAC(oc, AI);
		NAC += "\n#include <rest.h>\n";
		List<String> strs=wan.getMatch(oc, "\"", "\"");
		try
		{
			for (int i=0;i < strs.size();i++)
			{
				strs.set(i, RC4Util.encryRC4String(strs.get(i), STR_KEY, "UTF-8"));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		List<String> p1=new ArrayList<>();
		List<String> p2=new ArrayList<>();
		for (int i=0;i < strs.size();i++)
		{
			p1.add(wan.BIND_VARNAME5 + wan.getRandomStr());
			NAC += "int " + p1.get(i) + "[]={" + wan.toAscii(strs.get(i)) + "};";
			p2.add(wan.BIND_VARNAME2 + wan.getRandomStr());
			NAC += "int " + p2.get(i) + " = sizeof(" + p1.get(i) + ") / sizeof(" + p1.get(i) + "[0]);";
			strs.set(i, wan.BIND_VARNAME4 + "(YWlycGxhbmU(" + p1.get(i) + "," + p2.get(i) + "),wan_k)");
		}
		AC = wan.replaceStrs(AC, strs);
		return NAC + AC;
	}
	//C++函数名混淆(仅编译前)
	public String enc_fn(String oc)
	{
		int AI=wan.getAI(oc);
		String AC=wan.getAC(oc, AI);
		String NAC=wan.getNAC(oc, AI);
		List<String> funs=wan.getMatch(oc, "", "(");
		List<String> funs1=wan.getMatch(oc, " ", "(");
		//搜索函数名
		for (int i=0;i < funs.size();i++)
		{
			if (funs.get(i).equals("") ||
				funs.get(i).indexOf(" ") != -1)
			{
				funs.remove(i);
			}
		}
		for (int i=0;i < funs1.size();i++)
		{
			if (funs1.get(i).equals("") ||
				funs1.get(i).indexOf(" ") != -1)
			{
				funs1.remove(i);
			}
		}
		//淘汰重复的函数名
		for (int i=0;i < funs.size();i++)
		{
			for (int j=0;j < funs.size();j++)
			{
				if (i != j && funs.get(i).equals(funs.get(j)))
				{
					funs.remove(i);
				}
			}
		}
		for (int i=0;i < funs1.size();i++)
		{
			for (int j=0;j < funs1.size();j++)
			{
				if (i != j && funs1.get(i).equals(funs1.get(j)))
				{
					funs1.remove(i);
				}
			}
		}
		for (int i=0;i < funs.size();i++)
		{
			for (int j=0;j < funs1.size();j++)
			{
				if (funs.get(i).equals(funs1.get(j)))
				{
					funs.remove(i);
				}
			}
		}
		List<String> p1=new ArrayList<>();
		int s1=0;
		for (int i=0;i < funs.size();i++)
		{
			p1.add("wan" + wan.getRandomStr());
			NAC += "\n#define " + p1.get(i) + " " + funs.get(i);
		}
		s1 = p1.size();
		for (int i=0;i < funs1.size();i++)
		{
			p1.add("wan" + wan.getRandomStr());
			NAC += "\n#define " + p1.get(i + s1) + " " + funs1.get(i);
		}
		for (int i=0;i < funs1.size();i++)
		{
			funs.add(funs1.get(i));
		}
		AC = wan.replaceFns(AC, funs, p1);
		oc=NAC+AC;
		return oc;
	}
	
}
