n = int(input())
a = [int(x) for x in input().split()]
t1 = []
t2 = []
for x in a:
	if x % 2 == 0:
		t1.append(x)
	else:
		t2.append(x)
t1.sort()
t2.sort()
i = len(t1) - 1
j = len(t2) - 1
while 1:
	if i >= 0 and j >= 0:
		i -= 1
		j -= 1
	elif i >= 0:
		i -= 1
		break
	else:
		break
s1 = 0
for r in range(i + 1):
	s1 += t1[r]
for r in range(j + 1):
	s1 += t2[r]
i = len(t1) - 1
j = len(t2) - 1
while 1:
	if i >= 0 and j >= 0:
		i -= 1
		j -= 1
	elif j >= 0:
		j -= 1
		break
	else:
		break
s2 = 0
for r in range(i + 1):
	s2 += t1[r]
for r in range(j + 1):
	s2 += t2[r]
print(min(s1, s2))
