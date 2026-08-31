from itertools import chain
DIST = int(1e6)
STOP = DIST//2
last = 1
input()
for a in chain(map(int, input().split()), [DIST]):
	if a > STOP:
		print(max(last-1, DIST-a))
		break
	last = a
