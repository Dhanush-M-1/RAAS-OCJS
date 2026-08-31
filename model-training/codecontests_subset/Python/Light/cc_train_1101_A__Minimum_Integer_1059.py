test = int(input())
while(test):
	test -= 1
	temp = list(map(int, input().split(" ")))
	l = temp[0]
	r = temp[1]
	d = temp[2]
	if d>r or d<l:
		print(d)
	else:
		t = r//d + 1
		print(d*t)