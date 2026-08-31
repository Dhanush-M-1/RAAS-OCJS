x,y = map(int,input().split())
m = [0]*y

for i in range(x):
	a = list(map(int,input().split()))
	for j in range(1,len(a)):
		m[a[j]-1]+=1
if 0 in m:
	print("NO")
else:
	print("YES")