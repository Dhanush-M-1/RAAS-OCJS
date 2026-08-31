def min_ints(l,r,d):
	if d < l:
		print(d)
		return
	else:
		print((r//d+1)*d)
		return




n = int(input())
for _ in range(n):
	l,r,d = list(map(int,input().split()))
	min_ints(l,r,d)
