x = input().split()
n = int(x[0])
k = int(x[1])
ans = 0

x = input().split()

for i in range(n):
	m = int(x[i])
	if k % m == 0:
		dummy = k // m
		if dummy < ans or ans == 0:
			ans = dummy
		
print(ans)