import sys

def find_smallest_sub_sequence(lst1, lst2):
	common_elements = []
	for item in lst1:
		if item in lst2:
			common_elements.append(item)
	if(common_elements == []):
		print("NO")
	elif(len(common_elements) >= 1):
		print("YES")
		print(1, end=" ")
		print(common_elements[0])

#find_smallest_sub_sequence([10, 8, 6, 4], [1, 2, 3, 4, 5])

n = int(sys.stdin.readline())
for i in range(int(n)):
	arr = [int(x) for x in sys.stdin.readline().split()]
	if(len(arr) == 2):
		lst1 = [int(x) for x in sys.stdin.readline().split()]
		lst2 = [int(x) for x in sys.stdin.readline().split()]
		if(len(lst1) == arr[0] and len(lst2) == arr[1]):
			find_smallest_sub_sequence(lst1, lst2)
	else:
		print("")