from functools import reduce

g=lambda x,y:x*y
cv=lambda s:str(max([reduce(g,list(map(int,[s[:i],s[i:]]))) for i in range(1,len(s))]))

for _ in range(int(input())):
	c=0
	n=input()
	s=set()
	while 1:
		if len(n)==1:break
		if n in s:
			c=-1
			break
		s.add(n)
		n=cv(n)
		c+=1
	print(c)

