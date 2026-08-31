n , m = map(int, input().split())
t = [False] * (m + 1)
for i in range(n):
	l = list(map(int, input().split()))
	for x in l[1:]:
		t[x] = True

poss = True
for x in t[1:]:
	if not x:
		poss = False

if poss:
	print("YES")
else:
	print("NO")
