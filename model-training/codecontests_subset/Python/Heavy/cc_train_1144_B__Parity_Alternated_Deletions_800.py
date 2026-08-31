amount = int(input())
arr = sorted([int(i) for i in input().split(' ')])

odd = 0 # нечетные
for i in arr:
    if i%2 != 0:
        odd += 1
        
even = len(arr)-odd # четные

diff = abs(even-odd)
if diff < 2:
    del arr
    print(0)
else:
    sum_val = 0
    i = 0
    diff -= 1
    while diff > 0:
        if even > odd:
          if arr[i]%2 == 0:
            sum_val += arr[i]
            diff -= 1
        elif odd >= even:
            if arr[i]%2 != 0:
                sum_val += arr[i]
                diff -= 1
        i += 1
    print(sum_val)