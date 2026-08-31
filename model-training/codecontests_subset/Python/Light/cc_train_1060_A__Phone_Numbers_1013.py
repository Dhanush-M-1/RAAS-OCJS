n=int(input())
s=list(str(input()))
e,m=0,0
if '8' not in s or n<11:
	print(0)
else:
	e=s.count('8')
	m=n//11
	print(min(e,m))