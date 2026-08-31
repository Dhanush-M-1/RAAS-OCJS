def go():
    n, k = (int(i) for i in input().split(' '))
    a = sorted([int(i) for i in input().split(' ')], reverse=True)
    if len(a) == 1:
        return 1
    to_remove = 0
    i = 0
    while n > i + 1:
        if a[i] > a[i + 1] and a[i] <= a[i + 1] + k:
            to_remove += 1
            if i + 2 < n and a[i + 1] == a[i + 2]:
                i += 1
                while i + 1 < n and a[i] == a[i + 1]:
                    to_remove += 1
                    i += 1
                    found = True
                if found:
                    i -= 1
        i += 1

    return n - to_remove

print(go())
