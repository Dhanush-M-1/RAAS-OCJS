def bla(s):
	l=[]
	if len(s)==1:
		print(s) 
	else:
		for i in range(0,len(s),2):
			l.append(s[i])
	
		c1=l.count("1")
		c2=l.count("2")
		c3=l.count("3")

		if c1!=0:
			for i in range(0,c1-1):
				print("1+",end="")
			print("1",end="")
		if c2!=0:
			if c1!=0:
				print("+",end="")
			
			for j in range(0,c2-1):
				print("2+",end="")
			print("2",end="")
		if c3!=0:
			if c1!=0 or c2!=0:
				print("+",end="")
			
			for k in range(0,c3-1):
				print("3+",end="")
			print("3")

s=input()
bla(s)