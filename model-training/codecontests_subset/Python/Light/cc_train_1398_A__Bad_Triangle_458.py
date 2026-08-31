t = int(input())
for x in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    b = list(a)
    max1 = max(a)
    a.remove(max1)
    min1 = min(a)
    a.remove(min1)
    min2 = min(a)
    a.remove(min2)
    if (max1 >= (min1 + min2)):
        print(1, 2, len(b))
        continue
    a = b
    max1 = max(a)
    a.remove(max1)
    min1 = min(a)
    a.remove(min1)
    max2 = max(a)
    a.remove(min2)
    if max1 >= (max2 + min1):
        print(1, len(b) - 1, len(b))
    else:
        print(-1)