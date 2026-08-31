k = int(input().split()[1])
ai = input().split()
result = 0
for item in ai:
	a = int(item)
	if k % a == 0:
		if a > result:
			result = a

print(k//result)