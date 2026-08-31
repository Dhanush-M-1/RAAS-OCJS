x=[int(z) for z in input().split()]
a=x[0]
b=x[1]
count = a
n=a
while n>= b :
	n=n/b
	count = count + (n)
	
print(int(count+n/b))