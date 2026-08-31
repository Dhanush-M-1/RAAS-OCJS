n = int(input())
query = []
for i in range(n):
    query.append(int(input()))
for i in query:
    if i == 1:
        print(0)
        continue
    if i == 3:
        print(2)
        continue
    if i < 6:
        print(-1)
        continue
    elif i % 3 != 0:
        print(-1)
        continue
    else:
        count = 0
        while i >= 6 and i % 3 == 0:
            if i % 6 == 0:
                i //= 6
                count += 1
            else:
                i *= 2
                count += 1
        if i == 1:
            print(count)
            continue
        if i == 3:
            print(count + 2)
            continue
        else:
            print(-1)
            continue



