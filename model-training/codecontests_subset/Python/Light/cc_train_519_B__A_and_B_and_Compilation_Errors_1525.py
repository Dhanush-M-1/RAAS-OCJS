n = int(input())
a = input()
a = a.split()
l1, l2, l3 = [], [], []
for num in a:
	l1.append(int(num))
a = input()
a = a.split()
for num in a:
	l2.append(int(num))
a = input()
a = a.split()
for num in a:
	l3.append(int(num))
print(sum(l1)-sum(l2))
print(sum(l2)-sum(l3))