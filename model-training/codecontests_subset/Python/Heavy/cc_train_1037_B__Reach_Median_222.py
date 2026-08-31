number = input().split()
n = int(number[0])
s = int(number[1])

a = list(map(int, input().split()))

a = sorted(a)
step = 0

mid = int(n/2)
if s < a[mid]:
    step += a[mid] - s
    a[mid] = s
    i = mid
    while i > 0:
        if a[i] >= a[i-1]:
            break
        else:
            step += a[i - 1] - a[i]            
            a[i - 1] = a[i]
            i -= 1
elif s > a[mid]:
    step += s - a[mid]
    a[mid] = s
    i = mid
    while i < n - 1:
        if a[i] <= a[i + 1]:
            break
        else:
            step += a[i] - a[i + 1]
            a[i + 1] = a[i]
            i += 1

print(step)
