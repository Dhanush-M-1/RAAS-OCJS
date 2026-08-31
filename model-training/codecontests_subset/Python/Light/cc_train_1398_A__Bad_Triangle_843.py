import sys

def input():
	return sys.stdin.readline().rstrip()

def input_split():
	return [int(i) for i in input().split()]

testCases = int(input())
answers = []
for _ in range(testCases):
	#take input
	n = int(input())
	arr = input_split()

	x,y,z = arr[0], arr[1], arr[-1]

	if x +y > z:
		ans = -1
	else:
		ans = "1 2 {}".format(n)

	answers.append(ans)

print(*answers, sep = '\n')
