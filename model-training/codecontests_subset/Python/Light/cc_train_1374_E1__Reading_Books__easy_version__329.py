n,k = map(int, input().split())
alice = []
bob = []
common = []
for i in range(n):
	t, a, b = map(int, input().split())
	if a and b:
		common.append(t)
	elif a:
		alice.append(t)
	elif b:
		bob.append(t)
alice.sort()
bob.sort()
for i in range(min(len(alice), len(bob))):
	common.append(alice[i]+bob[i])
if len(common)<k:
	print(-1)
else:
	common.sort()
	print(sum(common[:k]))