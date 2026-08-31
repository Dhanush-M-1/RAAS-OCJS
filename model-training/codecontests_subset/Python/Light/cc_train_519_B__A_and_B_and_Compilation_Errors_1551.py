input_ = input()
first = input()
second = input()
third = input()

first = sorted(map(int, first.split()))
second = sorted(map(int, second.split()))
third = sorted(map(int, third.split()))

for i in range(len(second)):
	if first[i] != second[i]:
		first_error = first[i]
		break
else:
	first_error = first[-1]

for i in range(len(third)):
	if second[i] != third[i]:
		second_error = second[i]
		break
else:
	second_error = second[-1]

print(first_error)
print(second_error)