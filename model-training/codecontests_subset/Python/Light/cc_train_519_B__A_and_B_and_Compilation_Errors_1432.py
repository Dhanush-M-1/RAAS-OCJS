def check(a, b):
	for i in range(len(b)):
		if a[i]!=b[i]:
			return a[i]
	return a[len(b)]
count=int(input())
num1=[int(s) for s in input().split()]
num2=[int(s) for s in input().split()]
num3=[int(s) for s in input().split()]
num1.sort()
num2.sort()
num3.sort()
print(check(num1, num2))
print(check(num2, num3))