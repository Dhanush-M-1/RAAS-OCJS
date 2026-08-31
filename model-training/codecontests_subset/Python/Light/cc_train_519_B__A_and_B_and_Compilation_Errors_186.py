n = int(input())

a1 = list(map(int, input().split()))
a2 = list(map(int, input().split()))
a3 = list(map(int, input().split()))

a1.sort()
a2.sort()
a3.sort()

ba2 = ba3 = 0
for i in range(n):
	if not ba2:
		if i == len(a2):
			ba2 = a1[i]			
		elif a1[i] != a2[i]:
			ba2 = a1[i]
	if not ba3:
		if i == len(a3):
			ba3 = a2[i]
		elif a2[i] != a3[i]:
			ba3 = a2[i]
			
	if ba2 and ba3:
		break

print(ba2)
print(ba3)
