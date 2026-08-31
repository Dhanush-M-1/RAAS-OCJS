n = int(input())
values = input()

values = values.split(' ')
for i in range(n):
	values[i] = int(values[i])

minimum = 1e6
val = -1
for i in range(n):
	t = abs(values[i] - (5e5+0.5))
	if t  < minimum:
		val = values[i]
		minimum = t

print(int(min(val - 1, 1e6 - val)))
