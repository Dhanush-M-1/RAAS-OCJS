num_cases = int(input())

for case in range(num_cases):
    n = int(input())

    min_num = 1000000027
    max_num = 0
    biggest = 0
    nums = input().split()
    for i in range(len(nums)):
        nums[i] = int(nums[i])

    for i in range(len(nums)):
        curr_num = nums[i]
        prev_num = nums[i - 1] 
        if (curr_num == -1):
            if (i != 0):
                if(prev_num != -1):
                    max_num = max(max_num, prev_num)
                    min_num = min(min_num, prev_num)
            if (i != len(nums) - 1):
                next_num = nums[i + 1]
                if(next_num != -1):
                    max_num = max(max_num, next_num)
                    min_num = min(min_num, next_num)
        elif (i != 0 and prev_num != -1):
            biggest = max(biggest, abs(curr_num - prev_num))

    if (min_num > max_num):
        ans = max_num
    else:
        ans = (min_num + max_num) // 2
    print(max(biggest, max(ans - min_num, max_num - ans)), end = ' ')
    print(ans)
    

				   	 	 				   		   		   			