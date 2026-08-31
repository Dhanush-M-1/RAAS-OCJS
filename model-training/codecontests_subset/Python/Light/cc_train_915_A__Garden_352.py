z = []
x,y = map(int,input().split())
a = list(map(int,input().split()))
for i in range(x):
	if y%a[i] == 0:
		z.append(int(y/a[i]))
print(min(z))