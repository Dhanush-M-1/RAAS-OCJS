problem=[]
problem.append(input())

nums=[]
for i in range(0, len(problem[0]), 2):
    nums.append(int(problem[0][i]))

length=len(nums)
sorted_nums=[]
smallest=0

while len(sorted_nums)<length:
    for i in range(len(nums)):
        if smallest==0:
            smallest=nums[i]
        elif nums[i]<smallest:
            smallest=nums[i]
        else:
            continue

    for j in range(len(nums)):
        if nums[j]==smallest:
            del nums[j]
            break
        else:
            continue

    sorted_nums.append(smallest)
    smallest=0
    len(sorted_nums)

final_ans=''

for k in range(len(sorted_nums)):
    if k<(len(sorted_nums)-1):
        final_ans+=str(sorted_nums[k])+'+'
    else:
        final_ans+=str(sorted_nums[k])

print(final_ans)