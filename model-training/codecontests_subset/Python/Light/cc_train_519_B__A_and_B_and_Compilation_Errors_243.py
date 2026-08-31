n = int(input())
l1 = [int(i) for i in input().split()]
l2 = [int(i) for i in input().split()]
l3 = [int(i) for i in input().split()]
l1.sort()
l2.sort()
l3.sort()
f = 1
for i in range(n-1):
	if l1[i] != l2[i] :
		print(l1[i])
		f = 0
		break
if f == 1:
	print(l1[n-1])
f = 1
for i in range(n-2):
	if l2[i] != l3[i] :
		print(l2[i])
		f = 0
		break
if f == 1 :
	print(l2[n-2])
