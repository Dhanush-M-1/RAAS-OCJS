def solve():
	nr = int(input())
	prv_play = 0
	prv_clear = 0
	s = True
	x = []
	for _ in range(nr):
		p, c = [int(x) for x in input().split(" ")]
		x.append((p, c))

	for a in x:
		p = a[0]
		c = a[1]

		if c > p:
			s = False
			break
		if c < prv_clear:
			s = False
			break
		else:
			delta = c - prv_clear
			if p < prv_play + delta:
				s = False
				break

		prv_play = p
		prv_clear = c

	if s:
		print("YES")
	else:
		print("NO")


def main():
	t = int(input())
	for _ in range(t):
		# a,b,s = [int(x) for x in input().split(" ")]
		solve()

main()