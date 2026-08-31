# import sys

# sys.stdin = open("input.txt", "r")
# sys.stdout = open("output.txt", "w")

t = int(input())

for _ in range(t):
	n = int(input())
	a = [int(i) for i in input().split()]

	if(a[0] + a[1] <= a[-1]):
		print("1 2", n)
	else:
		print("-1")