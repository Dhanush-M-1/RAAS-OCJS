n = int(input())
posn = []
height = []
for i in range(n):
	tree = list(map(int,input().split()))
	posn.append(tree[0])
	height.append(tree[1])
count = 2
choice = -1
for i in range(1,n-1):
	if choice <=0 :
		if posn[i] - posn[i-1] > height[i]:
			choice = -	1
			count+=1
		elif posn[i+1] - posn[i] > height[i]:
			choice = 1
			count+=1
		else:
			choice = 0
	else:
		if posn[i] - posn[i-1] - height[i-1] > height[i]:
			choice = -	1
			count+=1
		elif posn[i+1] - posn[i] > height[i]:
			choice = 1
			count+=1
		else:
			choice = 0
if n==1:
	count = 1
print(count)			
