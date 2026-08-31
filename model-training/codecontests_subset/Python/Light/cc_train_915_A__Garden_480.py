r, k = map(int, input().split())
a = sorted(list(map(int, input().split())))

n = 0

for i in reversed(a):
	if k % i == 0:
		n = k // i
		break
print(n)