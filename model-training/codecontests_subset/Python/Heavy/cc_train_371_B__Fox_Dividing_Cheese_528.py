num1, num2 = [int(i) for i in input().split()]
opr = 0
arr_1 = []
arr_2 = []
a = 0
b = 0
c = 0
check = 1 
save = min(num1, num2)
num1 = max(num1, num2)
num2 = save
while num1 != 1 and num1 != num2:
	if num1 % 2 == 0:
		a += 1
		num1 /= 2
	elif num1 % 3 == 0:
		b += 1
		num1 /= 3
	elif num1 % 5 == 0:
		c += 1
		num1 /= 5
	else:
		break

while num2 != 1 and check and num1 != num2:
	if num2 % 2 == 0:
		a -= 1
		num2 /= 2
	elif num2 % 3 == 0:
		b -= 1
		num2 /= 3
	elif num2 % 5 == 0:
		c -= 1
		num2 /= 5
	else:
		break
if num1 == num2 :
	print(abs(a) +abs(b)+ abs(c))
else:
	print(-1)
