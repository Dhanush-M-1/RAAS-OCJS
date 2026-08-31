n,k = list(map(int,input().split()))
a = list(map(int,input().split()))
b=[]
for i in a:
	if k%i==0:
		b.append(i)
print(int(k/max(b)))