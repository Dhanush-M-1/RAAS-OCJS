#!/usr/bin/env python3

strlen = int(input())
eights = strlen - len(input().replace('8', ''))
strlen -= eights

res = 0
while True:
	if strlen >= 10 and eights > 0:
		res += 1
		strlen -= 10
		eights -= 1
	elif strlen + eights >= 11 and eights > 0:
		res += 1
		eights -= 11 - strlen
		strlen = 0
	else:
		break
print(res)
