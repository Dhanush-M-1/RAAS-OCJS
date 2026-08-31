import re, math, decimal, bisect
def read(): return input().strip()
def iread(): return int(input().strip())
def viread(): return [int(_) for _ in input().strip().split()]

# code goes here
for _ in range(iread()):
	l, r, d = viread()
	ans1 = r+1
	if d != 1:
		ans1 += (d - (ans1 % d)) % d
	ans2 = d
	print(ans1 if ans2 >= l and ans2 <= r else ans2)
