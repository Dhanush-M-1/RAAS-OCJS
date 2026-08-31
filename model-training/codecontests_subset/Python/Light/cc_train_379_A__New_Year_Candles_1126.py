a=[int(i) for i in input().split()]
n=a[0]
m=a[1]
days=n
i=1
t=int(days/m)
while t>=0:
	if days-i*m>=0:
		days+=1
	i+=1
	t=t-1
d=days-1
t=int(days/m)-i
while days-d==1:
	d=days
	if days-i*m>=0:
		days+=1
	i+=1
print(days)