# Строки
r1, r2 = map(int, input().split())

# Столбцы
c1, c2 = map(int, input().split()) 

# Диагонали
d1, d2 = map(int, input().split())

# x a  -- уникальные
# b c
status = False
for x in range(1, 10):
	a = r1 - x
	c = c2 - a
	b = r2 - c
	count = 0
	if len(set([x, a, b, c])) == 4:
		count += 1
	
	if a in range(1, 10) and b in range(1, 10) and c in range(1, 10) and x in range(1, 10):
		count += 1

	if x + c == d1 and a + b == d2:
		count += 1

	if count == 3:
		status = True
		break

if status:
	print(x, a)
	print(b, c)
else:
	print(-1)

















