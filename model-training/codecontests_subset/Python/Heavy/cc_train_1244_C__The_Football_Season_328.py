x = None
y = None
gcd = None


def ext_gcd(a, b):
	global x
	global y
	global gcd

	if b==0:
		x = 1
		y = 0
		gcd = a
		return

	ext_gcd(b, a%b)

	tmp = y
	y = x - y * (a//b)
	x = tmp


def main():
	global x
	global y
	global gcd

	n, p, w, d = input().split()
	n, p, w, d = int(n), int(p), int(w), int(d)
	ext_gcd(w, d);

	if p%gcd != 0:
		print("-1")
		return

	ans1 = p // gcd * x
	ans2 = p // gcd * y

	if ans2>=0:
		k = ans2 // (w // gcd)
		ans2 -= k * (w//gcd)
		ans1 += k * (d//gcd)
		if ans1+ans2 > n:
			print("-1")
			return
	else:
		k = (-ans2-1) // (w // gcd) + 1;
		ans2 += k * (w//gcd)
		ans1 -= k * (d//gcd)
		if ans1+ans2 > n:
			print("-1")
			return
	
	if ans1 < 0:
		print("-1")
		return

	print("{} {} {}".format(ans1, ans2, n-ans1-ans2))


if __name__ == '__main__':
	main()
	
