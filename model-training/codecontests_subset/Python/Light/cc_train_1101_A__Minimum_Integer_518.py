t = int(input())
for _  in range(t):
	l, r, d = [int(p) for p in input().split()]
	if d < l or d > r:
		print(d)
	else:
		print(d*(r//d + 1))
	
