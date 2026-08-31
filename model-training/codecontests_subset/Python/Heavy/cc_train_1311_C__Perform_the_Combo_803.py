def bs(left, right, pos, p):
    while right - left > 1:
        middle = (left + right) // 2
        if p[middle] < pos:
            left = middle
        else:
            right = middle
    return right


t = int(input())
for i in range(t):
    count = dict()
    for j in "abcdefghijklmnopqrstuvwxyz":
        count[j] = 0

    n, m = map(int,input().split())
    s = input()
    p = list(map(int,input().split()))
    p.sort()
    m += 1
    p.append(n)

    for j in range(n):
        pos = (bs(-1, m, j + 1, p))
        count[s[j]] += (m - pos)
        #for k in "abcdefghijklmnopqrstuvwxyz":
        #    print(count[k], end = ' ')
        #print()


    for k in "abcdefghijklmnopqrstuvwxyz":
        print(count[k], end = ' ')
    print()
