count, target_median = input().split(' ')
count = int(count)
mid = count // 2
median = int(target_median)
line = input()
numbers = [int(x) for x in line.split(' ')]

numbers.sort()

ops = 0

if numbers[mid] == median:
    pass
elif numbers[mid] > median:
    i = mid
    while i >= 0 and numbers[i] > median:
        ops += numbers[i] - median
        i -= 1
        
else:
    i = mid
    while i < count and numbers[i] < median:
        ops += median - numbers[i]
        i += 1
        
print(ops)