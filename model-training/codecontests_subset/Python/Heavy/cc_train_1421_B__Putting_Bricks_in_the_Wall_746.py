import sys
LI=lambda:list(map(int, sys.stdin.readline().strip('\n').split()))
MI=lambda:map(int, sys.stdin.readline().strip('\n').split())
SI=lambda:sys.stdin.readline().strip('\n')
II=lambda:int(sys.stdin.readline().strip('\n'))

for _ in range(II()):
	n=II()
	g=[]
	for i in range(n):
		g.append(list(SI()))
	if g[0][1]==g[1][0] and g[-1][-2]==g[-2][-1] and g[0][1]==g[-1][-2]:
		print(2)
		print(1, 2)
		print(2, 1)
	elif g[0][1]==g[1][0] and g[-1][-2]==g[-2][-1] and g[0][1]!=g[-1][-2]:
		print(0)
	elif g[0][1]!=g[1][0] and g[-1][-2]==g[-2][-1]:
		print(1)
		if g[0][1]==g[-1][-2]:
			print(1, 2)
		else:
			print(2, 1)
	elif g[0][1]==g[1][0] and g[-1][-2]!=g[-2][-1]:
		print(1)
		if g[0][1]==g[-1][-2]:
			print(n, n-1)
		else:
			print(n-1, n)
	elif g[0][1]!=g[1][0] and g[-1][-2]!=g[-2][-1]:
		print(2)
		print(2, 1)
		if g[0][1]==g[-1][-2]:
			print(n, n-1)
		else:
			print(n-1, n)