n = int(input())
arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))
arr3 = list(map(int,input().split()))
arr1.sort()
arr2.sort()
arr3.sort()
flag1 =False
flag2=False
for i in range(n-1):
	if arr1[i] ^ arr2[i] != 0:
		print(arr1[i])
		flag1 =True
		break
if not flag1:
	print(arr1[-1])
for k in range(n-2):
	if arr2[k] ^ arr3[k] !=0:
		print(arr2[k])
		flag2 = True
		break
if not flag2:
	print(arr2[-1])
