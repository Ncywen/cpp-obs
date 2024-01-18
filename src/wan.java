/*
*---依赖库类---
*[Auther]wan
*[QQ]3609272496
*/
package top.wan.cppobs;
import java.util.*;
import java.util.regex.*;
import java.io.*;
public class wan
{
	public static final String STR_KEY="QXV0aGVyOndhbiBRUTozNjA5MjcyNDk2";
	public static final String BIND_VARNAME1="cXEzNjA5MjcyNDk2";
	public static final String BIND_VARNAME2="L_QXV0aGVyOndhbg";
	public static final String BIND_VARNAME3="YWlycGxhbmU";
	public static final String BIND_VARNAME4="V0FO";
	public static final String BIND_VARNAME5="wanV2Fu";
	public static List<String> getMatch(String input, String startPattern, String endPattern)
	{
        List<String> extractedStrings = new ArrayList<>();

        String regex = Pattern.quote(startPattern) + "(.*?)" + Pattern.quote(endPattern);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find())
		{
            String match = matcher.group(1);
            extractedStrings.add(match);
        }

        return extractedStrings;
    }
	public static String getRandomStr()
	{
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for (int i=0;i < 9;i++)
		{
			int number=random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
    public static String replaceStrs(String input, List<String> strs)
	{
        StringBuilder output = new StringBuilder(input);
        int start = output.indexOf("\"");
		int rsi=0;
        while (start != -1)
		{
            int end = output.indexOf("\"", start + 1);
            if (end != -1)
			{
				rsi++;
                output.replace(start, end + 1, strs.get(rsi));
                start = output.indexOf("\"", end + 1);
            }
			else
			{
                break;
            }
        }
        return output.toString();
    }
	public static String replaceFns(String input, List<String> fned, List<String> fning)
	{
		StringBuilder output = new StringBuilder(input);
		int start=0;
		int end=0;
		int rsi;
		for (int i=0;i < fned.size();i++)
		{
			while(output.indexOf(fned.get(i),end)!=-1){
			start = output.indexOf(fned.get(i),end);
			end = start + fned.get(i).length();
			output.replace(start, end, fning.get(i));
			}
			start=0;
			end=0;
		}
        return output.toString();
	}
	public static int[] listToArray(List<Integer> li)
	{
        int[] sum;
        sum = new int[li.size()];
        for (int i = 0; i < sum.length; i++)
		{
            sum[i] = li.get(i);
        }
        return sum;
    }
	public static List<Integer> getStrIndexs(String code, List<String> ms, int sn)
	{
		List<Integer> indexs=new ArrayList<>();
		int nm=0;
		for (int i=0;i < ms.size();i++)
		{
			nm = code.indexOf(ms.get(i));
			if (nm > sn)
			{
				indexs.add(nm);
			}
		}
		return indexs;
	}
	public static String getEncStr(String str)
	{
		String es=null;
		return es;
	}
	public static int getAI(String code)
	{
		int index=0;
		index = code.indexOf("(");

		char[] cchar=code.toCharArray();
		String[] carr=new String[code.length()];
		for (int i=0;i < cchar.length;i++)
		{
			carr[i] = String.valueOf(cchar[i]);
		}
		int nm=0;
		for (int i=0;i < index;i++)
		{
			if (carr[i].equals("\""))
			{
				nm = i;
			}
		}
		index = nm + 1;
		int i1=index;
		index = 0;
		index = code.indexOf("(");
		nm = 0;
		for (int i=0;i < index;i++)
		{
			if (carr[i].equals(">"))
			{
				nm = i;
			}
		}
		index = nm + 1;
		if (index > i1)
		{
			return index;
		}
		else
		{
			return i1;
		}
	}
	public static String getNAC(String code, int index)
	{
		String ac="";
		char[] cchar=code.toCharArray();
		String[] carr=new String[code.length()];
		for (int i=0;i < cchar.length;i++)
		{
			carr[i] = String.valueOf(cchar[i]);
		}
		for (int i=0;i < index;i++)
		{
			ac += carr[i];
		}
		return ac;
	}
	public static String getAC(String code, int index)
	{
		String nac="";
		char[] cchar=code.toCharArray();
		String[] carr=new String[code.length()];
		for (int i=0;i < cchar.length;i++)
		{
			carr[i] = String.valueOf(cchar[i]);
		}
		for (int i=index;i < cchar.length;i++)
		{
			nac += carr[i];
		}
		return nac;
	}
    public static String toAscii(String str)
	{
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++)
		{
            char c = str.charAt(i);
            int asciiValue = (int) c;

            result.append(asciiValue * 36);

            if (i != str.length() - 1)
			{
                result.append(",");
            }
        }
        return result.toString();
    }
	public static String readFileLine(String path)
	{
        String content = ""; // 文件内容字符串
        File file = new File(path); // 打开文件
        String line;
        String lines2 = "";
        List<Integer> li = new ArrayList<Integer>();
        int max = 0;
        int lines = 0;
        try
		{
            InputStream instream = new FileInputStream(file);
            if (instream != null)
			{
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);

                // 分行读取
                while ((line = buffreader.readLine()) != null)
				{
                    content += line + "\n";
                    lines++;
                    lines2 = lines2 + lines + "\n";
                    li.add(line.length());
                }
                instream.close();
            }
        }
		catch (java.io.FileNotFoundException e)
		{
        }
		catch (IOException e)
		{
        }
        return content;
    }
	public static boolean checkFiles(String path)
	{
        File file = new File(path);
        if (!file.exists() && !file.isDirectory())
		{
            return false;
        }
		else
		{
            return true;
        }
    }
	public static void removeFile(String path)
	{
        File file = new File(path);
        file.delete();
    }
	public static void writeFile(String path, String content)
	{
        if (checkFiles(path))
		{
            removeFile(path);
        }
        try
		{
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.append(content);
            fileWriter.flush();
            fileWriter.close();
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }
    }
}
