n = int(input())
l1 = sorted(list(map(int, input().split())))
l2 = sorted(list(map(int, input().split())))
l3 = sorted(list(map(int, input().split())))
for i in range(len(l1)):
	try:
		if l1[i] != l2[i]:
			print(l1[i])
			break
	except:
		print(l1[i])
for i in range(len(l2)):
	try:
		if l2[i] != l3[i]:
			print(l2[i])
			break
	except:
		print(l2[i])
  
