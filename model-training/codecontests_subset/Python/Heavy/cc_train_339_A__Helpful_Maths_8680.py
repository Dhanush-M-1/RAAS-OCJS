original_sum = input()
count_sort = [0] * 4
for i in range(0,len(original_sum),2):
	if int(original_sum[i]) == 1:
		count_sort[1] += 1
	elif int(original_sum[i]) == 2:
		count_sort[2] += 1
	else:
		count_sort[3] += 1
for i in range(0,len(original_sum),2):
	if count_sort[1] > 0:
		original_sum = original_sum[:i] + "1" + original_sum[i+1:]
		count_sort[1] -= 1
	elif count_sort[2] > 0:
		original_sum = original_sum[:i] + "2" + original_sum[i+1:]
		count_sort[2] -= 1
	else:
		original_sum = original_sum[:i] + "3" + original_sum[i+1:]
		count_sort[3] -= 1
print(original_sum)