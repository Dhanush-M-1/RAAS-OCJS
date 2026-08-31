n=int(input())
list1=sorted(list(map(int,input().split())))
list2=sorted(list(map(int,input().split())))
list3=sorted(list(map(int,input().split())))
for i in range(len(list1)):
	if i!= len(list2) and list1[i] != list2[i]:
		print(list1[i])
		break
	elif i== len(list2):
		print(list1[-1])
for i in range(len(list2)):
	if i!= len(list3) and list3[i] != list2[i]:
		print(list2[i])
		break
	elif i==len(list3):
		print(list2[-1])