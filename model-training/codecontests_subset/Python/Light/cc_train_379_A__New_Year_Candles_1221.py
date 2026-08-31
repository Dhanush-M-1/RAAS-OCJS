import math
def main():
	a, b = (int(i) for i in input().split(" "))
	l = a
	r = a
	while r >= b:
		a = r // b
		r += a - a * b
		l += a
	print(l)
	pass

if __name__ == "__main__":
	main()
