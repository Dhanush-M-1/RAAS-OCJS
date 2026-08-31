n,m = input().split()
n,m = [int(n),int(m)]

bulb =[]
for i in range(n):
	t = [int(x) for x in input().split()]
	for j in range(1,len(t)):
		bulb.append(t[j])

flag=0
for j in range(m):
	if not((j+1) in bulb):
		print("NO")
		flag= 1
		break

if flag == 0:		 
	print("YES")					
