import math
def na():
	n = int(input())
	b = [int(x) for x in input().split()]
	return n,b


def nab():
	n = int(input())
	b = [int(x) for x in input().split()]
	c = [int(x) for x in input().split()]
	return n,b,c


def dv():
	n, m = map(int, input().split())
	return n,m


def dva():
	n, m = map(int, input().split())
	b = [int(x) for x in input().split()]
	return n,m,b


def nm():
	n = int(input())
	b = [int(x) for x in input().split()]
	m = int(input())
	c = [int(x) for x in input().split()]
	return n,b,m,c


def dvs():
	n = int(input())
	m = int(input())
	return n, m


n,a = na()
nch = []
ch = []
for i in a:
	if i % 2 == 0:
		ch.append(i)
	else:
		nch.append(i)
ch = sorted(ch)
nch = sorted(nch)
while len(ch) > 0 and len(nch) > 0:
	ch.pop()
	nch.pop()
if len(ch) > 0:
	ch.pop()
elif len(nch) > 0:
	nch.pop()
print(sum(ch) + sum(nch))

