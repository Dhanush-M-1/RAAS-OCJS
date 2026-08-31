t = int(input())
for case in range(t):
    n = int(input())
    p = [int(x) for x in input().split(' ')]
    p_dict = {}
    for x in p:
        if x in p_dict.keys():
            p_dict[x] += 1
        else:
            p_dict[x] = 1
    p = [(k, v) for k, v in p_dict.items()]
    p.sort(reverse=True)
    p = [x[1] for x in p]
    m = [p[0], 0, 0]
    j = 1
    for i in range(1, len(p)):
        if j > 2:
            break
        if sum(m) + p[i] > n // 2:
            break
        elif j == 1 and m[j] > m[j - 1]:
            j += 1
        m[j] += p[i]
    if min(m) == 0 or m[2] <= m[0]:
        m = [0,0,0]
    print(*m)

