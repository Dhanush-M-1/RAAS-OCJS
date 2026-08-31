n = int(input())
arr1 = input().split()
for i in range(n):
	arr1[i] = int(arr1[i])

arr1 = sorted(arr1)

arr2 = input().split()
for i in range(n - 1):
	arr2[i] = int(arr2[i])

arr2 = sorted(arr2)

flag = False
for i in range(len(arr2)):
	if arr1[i] != arr2[i]:
		print(arr1[i])
		flag = True
		break

if flag == False:
	print(arr1[n - 1])


arr3  = input().split()

for i in range(n - 2):
	arr3[i] = int(arr3[i])

arr3 = sorted(arr3)

flag = False
for i in range(len(arr3)):
	if arr2[i] != arr3[i]:
		print(arr2[i])
		flag = True
		break


if flag == False:
	print(arr2[n - 2])