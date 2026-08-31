n = int(input())
first = list(map(int, input().split()))
second = list(map(int, input().split()))
third = list(map(int, input().split()))
first.sort()
second.sort()
third.sort()



def check(a, b):
	for i in range(len(b)):
		if a[i] != b[i]:
			return a[i]
	return a[-1]


print(check(first, second), check(second, third))



