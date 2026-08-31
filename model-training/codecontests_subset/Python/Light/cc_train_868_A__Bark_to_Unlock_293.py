s = input()
temp = []
for _ in range(int(input())):
	temp.append(input())
one = False
two = False
for x in temp:
	if(x[0] == s[1]):
		one = True
	if(x[1] == s[0]):
		two = True
print('YES' if ((one and two) or s in temp) else 'NO')

