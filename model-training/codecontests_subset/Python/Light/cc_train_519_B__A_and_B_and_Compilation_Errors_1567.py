length = input()
first = [int(i) for i in input().split()]
second = [int(i) for i in input().split()]
third = [int(i) for i in input().split()]
first = sorted(first)
second = sorted(second)
third = sorted(third)
a = 0
b = 0
for i in range(len(second)):
	if first[i] != second[i]:
		print(first[i])
		a = 1
		break
if a == 0:
	print(first[-1])
for i in range(len(second)-1):
	if third[i] != second[i]:
		print(second[i])
		b = 1
		break
if b == 0:
	print(second[-1])