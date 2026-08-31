
n = int(input())
l = sorted(list(map(int, input().split())))
l1 = sorted(list(map(int, input().split())))
l2 = sorted(list(map(int, input().split())))


for i in range(n - 1):
	if l1[i] != l[i]:
		print(l[i])
		break

else:
	print(l[-1])

for i in range(n - 2):
	if l1[i] != l2[i]:
		print(l1[i])
		break

else:
	print(l1[-1])
