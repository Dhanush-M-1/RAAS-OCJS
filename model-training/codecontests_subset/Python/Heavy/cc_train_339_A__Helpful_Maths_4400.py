def asc(lst):
    for items in range(len(lst) - 1):
        for num in range(len(lst) - 1):
            if lst[num] > lst[num + 1]:
                temp = lst[num + 1]
                lst[num + 1] = lst[num]
                lst[num] = temp


sumstr = input()
nums = list()

for i in range(len(sumstr)):
    if i % 2 != 0:
        continue
    else:
        nums.append(int(sumstr[i]))

asc(nums)

finstr = ""
for i in range(len(nums)):
    if i != len(nums) - 1:
        finstr = finstr + str(nums[i]) + '+'
    else:
        finstr = finstr + str(nums[i])
        
print(finstr)
