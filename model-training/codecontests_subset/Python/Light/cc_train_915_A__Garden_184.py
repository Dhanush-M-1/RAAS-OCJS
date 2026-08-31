x = list(map(int, input().split()))
y = list(map(int, input().split()))
A = []
for i in range(x[0]):
	if(x[1] % y[i] == 0):
		A.append(x[1]//y[i])

print(min(A))
