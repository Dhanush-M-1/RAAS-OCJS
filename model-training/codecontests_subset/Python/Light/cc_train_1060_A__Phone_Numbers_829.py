n = int(input())
nums = input()
max_nums = n // 11
eights = nums.count('8')
print(min(eights, max_nums))
