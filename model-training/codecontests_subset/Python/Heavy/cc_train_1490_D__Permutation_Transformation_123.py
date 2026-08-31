def find_max_i(a, s, e):
    m = s
    for i in range(s, e):
        if(a[i] > a[m]):
            m = i
    return m

def fill_d(a, r, s, e, d):
    if(s >= e):
        return
    r1 = find_max_i(a, s, e)
    d[r1] = d[r] + 1
    fill_d(a, r1, s, r1, d)
    fill_d(a, r1, r1 + 1, e, d)

t = int(input())
ans = []
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    d = [0] * n
    fill_d(a, find_max_i(a, 0, n), 0, n, d)
    ans.append(d)
for i in ans:
    for j in i:
        print(j - 1, end=" ")
    print()