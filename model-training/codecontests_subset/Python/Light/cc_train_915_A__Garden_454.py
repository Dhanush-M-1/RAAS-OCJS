# your code goes here
n,m = input().split()
n = int(n)
m = int(m)
a = list(map(int,input().split()))
ans= 1000
for c in a:
	if(m%c==0):
		g = m//c
		if(g < ans):
			ans = g
print(ans)