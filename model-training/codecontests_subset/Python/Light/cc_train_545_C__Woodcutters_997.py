# 1 向左砍
# 2 向右砍

lis = [[int(x) for x in input().split()] for i in range(int(input()))]
ans = 0
lef_lim = -1000000000
for i in range(len(lis)-1):
	if lis[i][0]-lis[i][1] > lef_lim:
		ans += 1
		lef_lim = lis[i][0]
	elif lis[i][0]+lis[i][1] < lis[i+1][0]:
		ans += 1
		lef_lim = lis[i][0]+lis[i][1]
	else:
		lef_lim = lis[i][0]
print(ans+1)