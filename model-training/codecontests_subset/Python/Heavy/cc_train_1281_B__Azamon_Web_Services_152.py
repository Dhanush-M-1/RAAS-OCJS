def solve(s,c):
    s = [ord(i) for i in list(s)]
    c = [ord(i) for i in list(c)]
    m = min(len(s), len(c))

    for i,x in enumerate(s):
        sm = min(s[i:])
        if x!=sm:
            ism = len(s[i:]) - s[i:][::-1].index(sm) + i - 1
            s[i], s[ism] = s[ism], s[i]
            break

    for i in range(m):
        if s[i]==c[i]: continue
        if s[i]>c[i]: return '---'
        break
    if c[:m]==s[:m] and len(c) <= len(s):
        return '---'

    return ''.join([chr(i) for i in s])

for _ in range(int(input())):
    s,c = input().split()
    print(solve(s,c))