import sys
LI=lambda:list(map(int, sys.stdin.readline().strip('\n').split()))
MI=lambda:map(int, sys.stdin.readline().strip('\n').split())
SI=lambda:sys.stdin.readline().strip('\n')
II=lambda:int(sys.stdin.readline().strip('\n'))
for _ in range(II()):
	n=II()
	a=LI()
	if a[0]+a[1]<=a[-1]:
		print(1, 2, n)
	else:
		print(-1)