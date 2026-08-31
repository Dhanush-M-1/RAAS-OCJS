import collections as cc
I=lambda:list(map(int,input().split()))
for tc in range(int(input())):
	n,=I()
	l=sorted(I())
	if (l[0]+l[1]<=l[-1]):
		print(1,2,n)
	else:
		print(-1)
		