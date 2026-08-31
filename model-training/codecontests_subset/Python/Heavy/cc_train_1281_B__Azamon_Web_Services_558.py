t = int(input())

for k in range(t):

	names = input().split(' ')

	my = list(names[0])
	comp = list(names[1])

	impossible = False

	initial = my.copy()

	less_than = False

	swapped = False

	impossible = False

	for i in range(min(len(my), len(comp))):

		if my[i] < comp[i]:
			less_than = True
			break

		elif not swapped:

			for j in range(len(my)-1, i, -1):

				if my[j] < comp[i]:

					temp = my[j]
					my[j] = my[i]
					my[i] = temp

					less_than = True
					break

			if less_than:
				break

			elif my[i] != comp[i]:

				for j in range(len(my)-1, i, -1):

					if my[j] == comp[i]:

						temp = my[j]
						my[j] = my[i]
						my[i] = temp
						swapped = True

				if not swapped:
					impossible = True
					break
		elif my[i] > comp[i]:
			impossible = True
			break

	if less_than or (not impossible and len(my) < len(comp)):
		print(''.join(my))

	else:
		print('---')


