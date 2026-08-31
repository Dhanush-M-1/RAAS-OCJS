
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
l2.sort(reverse = True)
for i in l2:
	if l1[1] % i == 0:
		print(l1[1] // i)
		exit() 