n, k = map(int, input().split())
a = list(map(int, input().split()))
Ans = 100
for i in range(n) :
	if k % a[i] == 0 :
		Ans = min(Ans, k // a[i])
print(Ans)
