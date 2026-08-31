def is_it_poss(l):
    prev_p = prev_c = 0
    for i in l:
        p, c = i
        if prev_p > p or prev_c > c:
            return "NO"
        if c > p:
            return "NO"
        plays_diff = p - prev_p; clears_diff = c - prev_c
        if clears_diff > plays_diff:
            return "NO"
        prev_p = p; prev_c = c
    return "YES"


t = int(input())
for i in range(t):
    n = int(input())
    l = []
    for j in range(n):
        p, c = list(map(int, input().split()))
        l.append([p, c])
    print(is_it_poss(l))

