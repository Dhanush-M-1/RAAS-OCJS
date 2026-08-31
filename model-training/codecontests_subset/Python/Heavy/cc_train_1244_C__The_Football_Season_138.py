import math

def solve(n, p, w, d) :
	x = int(p / w)
	p = p - w * x

	curr = 0
	cm = p % d
	y = -1
	while(curr <= x) :
		if(((p + curr * w) % d) == 0) :
			y = int((p + curr * w) / d)
			break
		if(curr > 0 and ((p + curr * w) % d) == cm) :
			break
		curr = curr + 1

	x = x - curr
	if(x + y <= n and y != -1) :
		return x, y, n - x - y
	else :
		return -1

def main() :
	n, p, w, d = list(map(int, input().split()))
	a = solve(n, p, w, d)
	
	if(a != -1) :
		for i in range(3) :
			print(a[i], end = ' ')
		print()
	else :
		print(-1)

main()