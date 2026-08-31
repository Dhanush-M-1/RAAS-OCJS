abStr = input()
a = int(abStr.split()[0])
b = int(abStr.split()[1])

time = 0
while a>=b:
	a = a-b
	a = a+1
	time = time + b

time = time + a

print(time)