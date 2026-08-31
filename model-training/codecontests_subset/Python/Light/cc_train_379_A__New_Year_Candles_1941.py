num=[int(i) for i in input().split()]
a=num[0]
b=num[1]
t=int(a/b)
c=0
pro=a
while int(a/b)!=0:
	pro=pro+int(a/b)
	c=a%b
	a=int(a/b)+c
print(pro)