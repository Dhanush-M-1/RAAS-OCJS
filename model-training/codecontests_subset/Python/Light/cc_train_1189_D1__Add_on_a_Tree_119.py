n = int(input())
degree = [0 for i in range(n)]
for i in range(n-1):
	a = [int(i) for i in input().split()]
	x = a[0]-1
	y = a[1]-1
	degree[x]+=1
	degree[y]+=1
flag = 0
for i in range(n):
	if(degree[i] == 2):
		flag=1
		break
if(flag==0):
	print("YES")
else:
	print("NO")