'''input
5
2 4 2
5 10 4
3 10 1
1 2 3
4 6 5
'''
n=int(input())
for i in range(n):
	l,r,d=map(int,input().strip().split(' '))
	if d<l or d>r:
		print(d)
	else:
		k=d-r%d
		ans=r+k
		print(ans)