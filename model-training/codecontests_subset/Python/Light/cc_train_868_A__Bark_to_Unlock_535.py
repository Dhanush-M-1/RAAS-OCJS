def main():
	p = input()
	first = False
	second = False
	N = int(input())
	for n in range(N):
		r = input()
		if r == p:
			first = True
			second = True
		if r[0] == p[1]:
			second = True
		if r[1] == p[0]:
			first = True
	if first and second:
		print("YES")
	else:
		print("NO")


main()


# 1507314150394
