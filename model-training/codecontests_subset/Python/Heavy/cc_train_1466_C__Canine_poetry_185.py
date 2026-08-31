t = int(input())
for _ in range(t):
    a = list(input())
    count = 0
    if len(a) == 1:
        print(0)
        continue
    for i in range(len(a) - 2):
        if a[i] == -1:
            count += 1
            continue
        if a[i] == a[i + 1]:
            a[i + 1] = -1
        if a[i] == a[i + 2]:
            a[i + 2] = -1
    if a[-2] == -1:
        count += 1
    if a[-1] == -1:
        count += 1
    if (a[-1] != -1 and a[-2] != -1) and a[-1] == a[-2]:
        count += 1
    print(count)
