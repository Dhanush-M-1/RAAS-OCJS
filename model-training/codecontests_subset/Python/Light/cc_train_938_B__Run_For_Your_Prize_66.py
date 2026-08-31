input()
numbers = [int(x) for x in input().split()]

max_left = 1
min_right = 1_000_000
for num in numbers:
    if num <= 500_000:
        max_left = num
    else:
        min_right = num
        break

res = max(max_left - 1, 1_000_000 - min_right)
print(res)
