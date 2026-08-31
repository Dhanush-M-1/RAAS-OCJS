n,k = map(int, input().split())
ans = 100000000000

for i in input().split():
	x = int(i)
	if (k%x == 0):
		if (int(k/x) < ans):
			ans = int(k/x)

print(ans)