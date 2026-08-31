n, k = list(map(int, input().split()))
both, ab, ba = [0], [0], [0]

for i in range(n):
	t, a, b = list(map(int, input().split()))
	if a == 1 and b == 1:
		both.append(t)
	elif a == 1:
		ab.append(t)
	elif b == 1:
		ba.append(t)

both, ab, ba = sorted(both), sorted(ab), sorted(ba)
for i in range(1, len(both)):
	both[i] = both[i] + both[i-1]

for i in range(1, len(ab)):
	ab[i] = ab[i] + ab[i-1]

for i in range(1, len(ba)):
	ba[i] = ba[i] + ba[i-1]

mini = None

for i in range(min(k+1, len(both))):
	rest = k - i

	if len(ab)-1 < rest or len(ba)-1 < rest:
		pass
	else:
		cur = both[i] + ab[rest] + ba[rest]
		mini = min(mini, cur) if mini is not None else cur

if mini is None:
	print("-1")
else:
	print(mini)