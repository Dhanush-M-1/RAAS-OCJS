# ===============================
# (c) MidAndFeed aka ASilentVoice
# ===============================
import math, fractions
# ===============================
n, m = [int(x) for x in input().split()]
q = []
for _ in range(n):
	t = [int(x) for x in input().split()][1:]
	for x in t:
		q.append(x)
print("YES" if len(set(q)) == m else "NO")