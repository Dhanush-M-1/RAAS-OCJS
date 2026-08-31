n = int(input())
l = [[int(i) for i in input().split()] for i in range(n)]	

for i in range(n):
	if l[i][2] < l[i][0]:
		print(l[i][2])
	else:
		print(l[i][1]//l[i][2]*l[i][2] + l[i][2]) 
