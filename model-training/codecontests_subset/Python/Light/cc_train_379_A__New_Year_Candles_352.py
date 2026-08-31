s = input()
a = s.split()
for i in range(len(a)):
	a[i] = int(a[i])

i = a[0]
while a[1] <= a[0]:
	i += int(a[0] / a[1])
	n = a[0] % a[1]
	m = int(a[0] / a[1])
	a[0] = a[0]%a[1] + int(a[0]/a[1])

print(i)