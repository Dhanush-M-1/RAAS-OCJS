n = int(input())
a =[]
even_list = []
odd_list = []
a_string = input()
a = (a_string.strip()).split(' ')
a = [int(i) for i in a]

for i in range(n):
	if a[i] % 2 == 0:
		even_list.append(a[i])
	else:
		odd_list.append(a[i])

even_len = len(even_list)
odd_len = len(odd_list)

if((even_len == odd_len) | ((even_len+1) == odd_len)) | ((odd_len+1) == even_len):
	print("0")
elif(even_len > odd_len):
	even_list.sort()
	index = -1 * (odd_len+1)
	even_list = even_list[:index]
	print(sum(even_list))
elif(odd_len > even_len):
	odd_list.sort()
	index = -1 * (even_len+1)
	odd_list = odd_list[:index]
	print(sum(odd_list))



