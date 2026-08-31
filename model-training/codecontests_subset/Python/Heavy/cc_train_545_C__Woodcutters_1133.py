def cut(l):
    if len(l) <= 2:
        return len(l)

    count = 2

    prevEnd = l[0][0]
    for i in range(1, len(l) - 1):
        x, h = l[i]
        nextEnd = l[i + 1][0]

        # print(x, prevEnd, nextEnd)

        if x - h > prevEnd:
            # fall left
            prevEnd = x
            count += 1

            # print(x, 'left')
            continue

        if x + h < nextEnd:
            # fall right
            prevEnd = x + h
            count += 1
            # print(x, 'righ')
            continue

        prevEnd = x

    return count


n = int(input())
l = list()
for _ in range(n):
    l.append(tuple(map(int, input().split())))

print(cut(l))
