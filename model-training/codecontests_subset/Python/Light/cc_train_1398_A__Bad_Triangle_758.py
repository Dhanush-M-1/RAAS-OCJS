t = int(input())
while(t>0):
	t -= 1
	n = int(input())
	line = input().split(" ")
	numbers = []
	for i in line:
		numbers.append(int(i))

	found = False
	# print(numbers)
	aa = -1
	bb = -1
	cc = -1
	i = 0
	j = 1
	k = n - 1
	a = numbers[i]
	b = numbers[j]
	c = numbers[k]
	if a+b>c and a+c>b and b+c>a:
		found = True
	else:
		found = False
		aa = i + 1
		bb = j + 1
		cc = k + 1



	if found:
		print("-1")
	else:
		print("{} {} {}".format(aa, bb, cc))
