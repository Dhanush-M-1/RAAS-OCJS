testCases = int(input())
for i1 in range(testCases):
    l = int(input())
    s = list(map(int, input().split()))
    t = []
    diff = []
    for i2 in range(l):
        if s[i2] != -1:
            if i2 == 0:
                if s[i2 + 1] == -1:
                    t.append(s[i2])
            elif i2 == l - 1:
                if s[i2 - 1] == -1:
                    t.append(s[i2])
            else:
                if s[i2 + 1] == -1 or s[i2 - 1] == -1:
                    t.append(s[i2])
            if i2 != l - 1:
                if s[i2 + 1] != -1:
                    diff.append(abs(s[i2 + 1] - s[i2]))
    max_diff = 0
    if len(diff) > 0:
        max_diff = max(diff)
    if len(t) == 0:
        print(max_diff, 1)
    else:
        max_t = max(t)
        min_t = min(t)
        t_diff = max_t - min_t
        if t_diff % 2 == 0:
            k = (max_t + min_t)//2
            t_diff = t_diff // 2
        else:
            k = (max_t + min_t)//2 + 1
            t_diff = (t_diff // 2) + 1
        print(max(max_diff, t_diff), k)
