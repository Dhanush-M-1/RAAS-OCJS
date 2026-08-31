import collections 
def solve(lst):
	if len(lst) < 3:
		return -1
	if lst[0] + lst[1] <= lst[len(lst)-1]:
		return str(1) + " "+str(2)+ " " +(str(len(lst)))
	return -1

def sort(key):
	return key[0]
ans=[]
n = int(input())
for i in range(n):
	k=int(input())
	lst= list(map(int,input().split()))
	ans.append(solve(lst))
for i in ans:
	print(i)


# for i in ans:
# 	print(i)
