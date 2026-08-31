t = int(input())
for _ in range(t):
    n, m = tuple(int(i) for i in input().split(' '))
    s = [ord(i) for i in input()]
    p = [int(i) for i in input().split(' ')]
    numbers = [0 for i in range(n)]

    max = 0

    for i in range(m):
        numbers[p[i] - 1] += 1
        if p[i] > max:
            max = p[i]

    p = []

    for i in range(max):
        if numbers[i] > 0:
            p += [i + 1]

    letters = [0]*26
    l = 0
    for i in range(n):
        letters[s[i] - 97] += m + 1
        if l < len(p) and i + 1 == p[l]:
            m -= numbers[p[l] - 1]
            l += 1

    ans = []
    for i in letters: ans.append(str(i))
    print(' '.join(ans))