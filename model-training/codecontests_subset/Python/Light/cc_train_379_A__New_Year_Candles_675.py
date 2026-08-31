A, B = map(int, input().split())
sum = 0
stock = 0
while True:
	sum += A
	if A+stock < B: break
	newA = (A+stock) // B
	stock = (A+stock) % B
	A = newA
print(sum)