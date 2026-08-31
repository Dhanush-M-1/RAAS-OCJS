'''input
5
2 4 2
5 10 4
3 10 1
1 2 3
4 6 5
'''
from sys import stdin


# main starts
q = int(stdin.readline().strip())
for _ in range(q):
	l, r, d = list(map(int, stdin.readline().split()))
	if l > d:
		print(d)
		
	else:
		temp = r // d
		print((temp + 1) * d)





