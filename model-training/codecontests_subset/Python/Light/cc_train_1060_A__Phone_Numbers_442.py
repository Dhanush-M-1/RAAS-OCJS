n=int(input())
s=input()
x=len(s)
c=0
for i in range(x):
	if s[i]=='8':
		c=c+1	
if c>=1 and c<int(n/11):
	print(c)
elif c>=1 and c>=int(n/11):
	print(int(n/11))
else:
	print("0")