def work(s,n):
	s_copy=s[:]
	s_copy.sort()
#	print(s_copy,s)
	for i in range(n):
		if(s_copy[i]==s[i]):
			continue
		for j in range(n-1,i,-1):
			if(s[j]==s_copy[i]):
				s[i],s[j]=s[j],s[i]
				return

for _ in range(int(input())):
	s,c=map(list,input().split(" "))
	work(s,len(s))
	broke=0
	for i in range(min(len(s),len(c))):
		if(s[i]>c[i]):
			print("---")
			broke=1
			break
		if(s[i]<c[i]):
			print(*s,sep="")
			broke=2
			break

	if(broke==0):
		if(len(c)<=len(s)):
			print("---")
		else:
			print(*s,sep="")

# from selenium import webdriver
# browser = webdriver.Chrome(executable_path='C:\\Users\\Dell\\.wdm\\drivers\\chromedriver\\79.0.3945.36\\win32\\chromedriver.exe')
# browser.get("http://cbseresults.nic.in/ctetD19/ctetD19.htm")

# start=123026000

# while True:
# 	username = browser.find_element_by_xpath("//input[@name='regno']")
# 	submit = browser.find_element_by_xpath("//input[@name='B1']")
# 	username.clear()
# 	username.send_keys(str(start))
# 	submit.click()
# 	html = browser.page_source
# 	if(html.find("VASANT")!=-1):
# 		print("hello")
# 		break
# 	browser.back()
# 	start+=1