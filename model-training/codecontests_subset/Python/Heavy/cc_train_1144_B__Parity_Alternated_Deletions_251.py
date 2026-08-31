n = int(input())
arr = list(map(int, input().split()))
even = 0
ev = []
od = []
odd = 0
for i in range(n):
    if arr[i] % 2 == 0:
        even += 1
        ev.append(arr[i])
    else:
        odd += 1
        od.append(arr[i])
ev.sort()
od.sort()

if abs(even - odd) == 0 or abs(even - odd) == 1:
    print(0)
else:
    arrsum = 0
    if even > odd:
        diff = even - odd - 1
        for i in range(diff):
            arrsum += ev[i]
    else:
        diff = odd - even - 1
        for i in range(diff):
            arrsum += od[i]
    print(arrsum)
