def main():
	q = int(input())

	for t in range(q):
		l , r, d = input().split()

		l = int(l)
		r = int(r)
		d = int(d)

		if d > r or d < l:
			print(d)
		else:
			print(r + d - r%d)

if __name__ == "__main__":
	main()
	