n=int(input())
string=input()
a=string.count('8')
if(a>(n//11)):
	a=n//11
print(min(a,(n-a)//10))