
from collections import defaultdict as dd
from math import log
def solve():
	n = int(input())
	#x, y, n = list(map(int, input().split()))
	#a = list(map(int, input().split()))
	#s = list(input())
	ans = 0
	flag = 0
	while n>1:
		while n%6==0:
			n = n//6
			ans += 1
		if n==1: break
		if n%3==0:
			n *=2
			ans += 1
			continue
		else:
			flag = 1
			break
	if flag == 1: print(-1)
	else:
		print(ans)


	
##################################################################
if __name__ == "__main__":
	t = 1
	t = int(input())
	for _ in range(t): solve()