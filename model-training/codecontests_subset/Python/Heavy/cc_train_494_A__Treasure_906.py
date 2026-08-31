# HEY STALKER
def solve():
    l = list(input())
    n = len(l)
    idx = 0
    c = 0
    for i in l:
        if i == "#":
            c += 1
    for t in range(n-1, -1, -1):
        if l[t] == "#":
            idx = t
            break
    for t in range(n):
        if l[t] == "#":
            l[t] = ")"
    k = [0 for t in range(n)]
    if l[0] == ')':
        return [-1]
    k[0] = 1
    for t in range(1, n):
        if l[t] == ")":
            k[t] = k[t-1] - 1
        else:
            k[t] = k[t-1] + 1
        if k[t] < 0:
            return [-1]
    v = [0 for i in range(n)]
    if l[-1] == "(":
        return [-1]
    v[-1] = 1
    for t in range(n-2, idx-1, -1):
        if l[t] == ")":
            v[t] = v[t+1] + 1
        else:
            v[t] = v[t+1] - 1
    v[idx] -= 1
    k[idx] += 1
    if v[idx] < 0:
        return [-1]
    if v[idx] == k[idx] or k[idx] == 0:
        return [-1]
    if v[idx] >= k[idx]:
        return [-1]
    ans = k[idx] - v[idx]
    x = [1 for i in range(c)]
    x[-1] = ans
    return x
z = solve()
for iu in z:
    print(iu)