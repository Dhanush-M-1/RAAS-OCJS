def merge_sort(int_list, length):
	if length == 0:
		return []	

	if length == 1:
		return [int_list[0]]

	res = []
	len_1 = length // 2
	len_2 = length - len_1
	left = merge_sort(int_list[:len_1], len_1)
	right = merge_sort(int_list[len_1:], len_2)
	
	i_left = 0
	i_right = 0
	
	# Dit kan meer pythonic
	while i_left < len_1 and i_right < len_2:
		while i_left < len_1 and i_right < len_2 and left[i_left] <= right[i_right]:
			res.append(left[i_left])
			i_left += 1
		while i_right < len_2 and i_left < len_1 and right[i_right] <= left[i_left]:
			res.append(right[i_right])
			i_right += 1

	# Een rij is leeg, de ander niet
	if i_left == len_1:
		res.extend(right[i_right:])
	else:
		res.extend(left[i_left:])

	return res

op = '+'
string = input()
if string == '':
	print()
	exit(0)

numbers = [int(i) for i in string.split(op)]
# Dit kan natuurlijk ook met de sorted methode van python

res_list = merge_sort(numbers, len(numbers))

res_str = ''
for res in res_list:
	res_str += str(res) + op
res_str = res_str[:-1]

print(res_str)
