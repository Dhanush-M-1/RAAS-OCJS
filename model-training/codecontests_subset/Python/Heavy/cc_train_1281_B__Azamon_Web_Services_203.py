# HEY STALKER
def swap(z, a, b):
    l = []
    for j in z:
        l.append(j)
    temp = l[a]
    l[a] = l[b]
    l[b] = temp
    zz = ""
    for tt in l:
        zz += tt
    return zz
def solve(s, k):
    for t in range(min(len(s), len(k))):
        if s[t] == k[t]:
            x = min(s[t:])
            if x < k[t]:
                for i in range(len(s)-1, t-1, -1):
                    if s[i] == x:
                        s = swap(s, t, i)
                        break
            if s < k:
                return s
        if s[t] > k[t]:
            x = min(s[t:])
            if x <= k[t]:
                for i in range(len(s)-1, t-1, -1):
                    if s[i] == x:
                        s = swap(s, t, i)
                        break
            if s < k:
                return s
            else:
                return "---"
    return "---"
for _ in range(int(input())):
    s, k = input().split()
    if s < k:
        print(s)
    else:
        print(solve(s, k))