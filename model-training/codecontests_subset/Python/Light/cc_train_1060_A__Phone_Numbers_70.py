n=int(input())
s=list(input())
a=n//11
b=s.count('8')
if b>=a:
	print(a)
elif(b<a):
	print(b)