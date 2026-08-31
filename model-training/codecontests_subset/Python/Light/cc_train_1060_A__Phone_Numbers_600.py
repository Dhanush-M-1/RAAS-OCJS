a=int(input())
b=input()
c=b.count('8')
d=len(str(b))//11
if c>d:
	print(d)
elif d>=c:
	print(c)
else:
	print(-1)