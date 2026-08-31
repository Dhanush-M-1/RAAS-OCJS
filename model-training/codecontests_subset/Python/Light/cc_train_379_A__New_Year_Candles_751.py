a, b = map(int, input().split())

counter = a
temp = a
while temp//b != 0:
	counter += temp//b
	temp = temp//b if temp%b==0 else temp//b + temp%b

print(counter)