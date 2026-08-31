n = int(input())
li = list(map(int, input().strip().split()))
even = 0
odd = 0
for num in li:
    if num%2 == 0:
        even += 1
    else:
        odd += 1
even_first_deleted = False
diff = odd - even
left_nums = n - 2*even - 1
if odd == 0:
    even_first_deleted = True
    left_nums = even - 1
elif even == 0:
    left_nums = odd - 1
elif even > odd:
    even_first_deleted = True
    diff = even - odd
    left_nums = n - 2*odd - 1
li.sort()
sum = 0
i = 0
for num in li:
    if i >= left_nums:
        break
    elif even_first_deleted:
        if num%2 == 0:
            sum += num
            i += 1
    else:
        if num%2 != 0:
            sum += num
            i += 1
print(sum)
