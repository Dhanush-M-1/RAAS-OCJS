from sys import*
def cut(a):
	if(len(a) == 1):
		return 1
	else:
		cuts = 2
		for j in range(1,n-1):
			if((a[j][0] - a[j-1][0]) > a[j][1]):
				cuts = cuts+1
			else:
				if((a[j+1][0] - a[j][0]) > a[j][1]):
					cuts = cuts+1
					a[j][0] = a[j][0]+a[j][1]
		return cuts

n = int(input())
a = [[0 for x in range(2)]for y in range(n)]
for i in range(n):
	a[i] = list(map(int,input().strip().split()))[:2]
print(cut(a))