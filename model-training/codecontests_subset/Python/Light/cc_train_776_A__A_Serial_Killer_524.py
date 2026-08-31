x1, x2 = input().split()
n = int(input())
print(x1,x2)
for i in range(n):
	y1,y2 = input().split()
	if(x1 == y1):
		x1 = y2
	if(x2 == y1):
		x2 = y2
	print(x1,x2)