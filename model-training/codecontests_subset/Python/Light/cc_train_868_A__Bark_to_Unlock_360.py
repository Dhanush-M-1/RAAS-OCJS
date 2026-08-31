s = input()
n = int(input())
mas1 = []
mas2 = []
for i in range(n):
	x = input()
	if x == s:
		print ("YES")
		exit()
	mas1.append(x[0])
	mas2.append(x[1])
for i2 in range(len(mas2)):
	if mas2[i2] == s[0]:
		for i1 in range(len(mas1)):
			if mas1[i1] == s[1]:
				print ("YES")
				exit()
print ("NO")
