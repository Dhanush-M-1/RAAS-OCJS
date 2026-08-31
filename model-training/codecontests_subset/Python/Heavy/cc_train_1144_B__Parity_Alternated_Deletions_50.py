n = int(input())
A = sorted(list(map(int, input().split())))
odd = 0  # нечетное
even = 0
sum = 0
for i in range(n):
    if A[i] % 2 == 0:
        even += 1
    else:
        odd += 1
if even > odd:
    e = even - odd - 1
    i = 0
    while e > 0:
        if A[i] % 2 == 0:
            sum += A[i]
            e = e - 1
        i += 1
elif even < odd:
    o = odd - even - 1
    i = 0
    while o > 0:
        if A[i] % 2 == 1:
            sum += A[i]
            o = o - 1
        i += 1
print(sum)