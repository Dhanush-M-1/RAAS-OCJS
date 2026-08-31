n, m = map(int, input().split())
b = set()
for _ in range(n):
	a = list(map(int, input().split()))
	for j in range(1, len(a)):
		b.add(a[j])
print("YNEOS"[len(b)!=m::2])