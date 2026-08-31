import sys

def minp():
	return sys.stdin.readline().strip()

n = int(minp())
a = 0
b = 0
for i in minp().split():
	if i == '100':
		a += 1
	elif i == '200':
		b += 1
ok = False
for i in range(a+b*2):
	have = [a, b]
	will = [0, 0]
	for j in range(2):
		z = min((i-will[j]) // 2, have[1])
		have[1] -= z
		will[j] += z*2;
		z = min((i-will[j]), have[0])
		have[0] -= z
		will[j] += z
	if will[0] == i and will[1] == i and have[0] == 0 and have[1] == 0:
		print("YES")
		ok = True
		break
if not ok:
	print("NO")
