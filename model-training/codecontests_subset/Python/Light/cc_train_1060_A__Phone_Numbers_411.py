n=int(input())
s=input()
def ct():
	c=0
	for d in s:
		if d=='8':
			c+=1
	return c
c=ct()
m=n//11
print(min(m,c))
