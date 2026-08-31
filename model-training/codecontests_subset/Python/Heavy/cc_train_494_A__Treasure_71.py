from sys import stdin
from sys import exit

live = True
if not live: stdin = open('data.in', 'r')

s = stdin.readline()
s = list(s)
limit = len(s)
open = []
ans = []
diez = 0
for it in range(limit):
	if s[it] == '(':
		open += [it]
	if s[it] == ')':
		if len(open) == 0:
			print(-1)
			exit(0)
		s[it] = s[open[-1]] = 0
		open.pop(-1)
	if s[it] == '#':
		diez += 1

pOpen = 0
for it in s:
	if it == '(':	
		pOpen += 1
	if it == '#':
		if diez > 1:
			if pOpen > 0:
				pOpen -= 1
				ans += [1]
			else:
				print(-1)
				exit(0)
		if diez == 1:
			if pOpen > 0:
				ans += [pOpen]
				pOpen = 0
			else:
				print(-1)
				exit(0)
		diez -= 1
if pOpen > 0:
	print(-1)
	exit(0)
print('\n'.join(map(str, ans)))
		
if not live: stdin.close()