import fractions

def main():
	t = int(input())
	qs = [list(map(int, input().split())) for _ in range(t)]
	for q in qs:
		sub(q)

def sub(q):
	a, b, c, d = q
	if d - b < 0:
		print("No")
		return
	
	if a - b < 0:
		print("No")
		return

	if b > c:
		gcd_bd = fractions.gcd(d, b)
		i = - 10
		while True:
			if 0 < gcd_bd * i + (a - c) % gcd_bd < b - c:
				print("No")
				return
			elif gcd_bd * i + (a - c) % gcd_bd >= b - c:
				print("Yes")
				return
			i += 1
				
	print("Yes")
	return
	
if __name__ == '__main__':
	main()
