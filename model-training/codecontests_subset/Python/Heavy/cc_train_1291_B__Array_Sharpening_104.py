from collections import defaultdict


q = int(input())
for _ in range(q):
    input()
    t1 = [int(x) for x in input().split(' ')]
    delim = -1
    for i in range(0, len(t1) - 1):
        nxt = t1[i + 1]
        if nxt > i:
            t1[i] = i
        else:
            delim = i
            break
    if delim == -1:
        print('YES')
    else:
        yes = True
        for j in range(delim + 1, len(t1)):
            prev = t1[j - 1]
            t1[j] = min(t1[j], prev - 1)
            if t1[j] < 0:
                yes = False
                break
        if yes:
            print('YES')
        else:
            print('NO')
