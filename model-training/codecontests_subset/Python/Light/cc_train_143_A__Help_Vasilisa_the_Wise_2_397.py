r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
i =  (d1 - c2 + r1) / 2
j = r1 - i
k = c1 - i
w = d1 - i
if len(set([i,j,k,w])) + sum([1<=i<=9,1<=j<=9,1<=k<=9,1<=w<=9]) == 8 and k + w == r2 and j + k == d2:
	print(int(i),int(j))
	print(int(k),int(w))
	exit()
print("-1")