import os, sys, math
from bisect import *

def main():
	n,k = [int(x) for x in input().split()]
	a = [int(x) for x in input().split()]
	a.sort(reverse=True)
	ans = 1
	eat_till = a[0] - k
	dont_eat = a[0]
	for x in a[1:]:
		debug("current: ",x," ... eating between [",dont_eat-1,",",eat_till,"], current ans:",ans,end=" ")
		if dont_eat > x >= eat_till:
			debug("eaten")
			eat_till = x - k
		else:
			ans += 1
			debug("added")
			eat_till = x - k
			dont_eat = x
	print(ans)

def debug(*args,**kwargs):
	if 'DEBUG' in os.environ:
		print(*args,**kwargs)

if __name__ == '__main__':
	main()