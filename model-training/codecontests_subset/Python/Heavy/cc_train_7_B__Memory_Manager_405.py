def d():
    global p
    j = 1
    for i in range(len(p)):
        p[i][0] = j
        j += p[i][1]
def e(k):
    global p
    for i in range(len(p)):
        if p[i][2] != k: continue
        p.pop(i)
        return
    print('ILLEGAL_ERASE_ARGUMENT')
def a(k):
    global p, s
    if not p:
        if k > m: return 'NULL'
        else:
            s += 1
            p = [[1, k, s]]
            return s
    d = 1
    for i in range(len(p)):
        if p[i][0] - d < k: d = p[i][0] + p[i][1]
        else:
            s += 1
            p.insert(i, [d, k, s])
            return s
    if m + 1 - d < k: return 'NULL'
    s += 1
    p.append([d, k, s])
    return s

n, m = map(int, input().split())
s, p = 0, []
for i in range(n):
    t = input()
    if t[0] == 'd': d()
    else:
        k = int(t[t.rfind(' ') + 1: ])
        if t[0] == 'e': e(k)
        else: print(a(k))