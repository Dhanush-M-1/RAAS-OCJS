from collections import defaultdict
n,m = list(map(int, input().split()))
d = defaultdict(int)

for _ in range(n):
	b = list(map(int, input().split()))
	for i in b[1:]:
		d[i] = 1

ans = "YES"	
for c in range(1,m+1):
	if d[c] == 0:
		ans = "NO"
		break
		
print(ans)