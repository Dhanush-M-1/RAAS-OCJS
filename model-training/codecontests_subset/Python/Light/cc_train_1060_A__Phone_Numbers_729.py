
n=int(input())
k=0
p=n//11
s=input()
for i in range(len(s)):
	if s[i]=='8':
		k+=1
	else:
		pass
if p<=k:
	print(p)
elif p>k:
	print(k)