r1 , r2 = map(int,input().split())
c1 , c2 = map(int,input().split())
d1 , d2 = map(int,input().split())
ans = [[0,0],[0,0]]
cnt = 1
while (cnt<10):
	ans[0][0] = cnt
	ans[0][1] = r1 - cnt
	ans[1][0] = c1 - cnt
	ans[1][1] = d1 - cnt
	if (ans[1][0]+ans[1][1]!=r2) or (ans[0][1]+ans[1][1]!=c2) or (ans[1][0]+ans[0][1]!=d2):
		ans = [[0,0],[0,0]]
		cnt+=1
	else:
		break
if len(list(set([ans[0][0],ans[0][1],ans[1][0],ans[1][1]])))!=4 or (max(ans[0])>9 or max(ans[1])>9) or (min(ans[0])<1 or min(ans[1])<1):
	print(-1)
else:
	print(ans[0][0],ans[0][1])
	print(ans[1][0],ans[1][1])