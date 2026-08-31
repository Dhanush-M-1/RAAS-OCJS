import sys
input = lambda: sys.stdin.readline().rstrip()
t = int(input())
for _ in range(t):
    s, t = input().split()
    s = list(s)
    ss = sorted(s)
    t = list(t)
    for i in range(len(s)):
        if s[i]==ss[i]:
            continue
        for j in range(len(s)-1, -1, -1):
            if s[j]==ss[i]:
                s[i], s[j] = s[j], s[i]
                break
        break
    for i, j in zip(s, t):
        if i<j:
            print(''.join(s))
            break
        elif i>j:
            print('---')
            break
    else:
        if len(s)<len(t):
            print(''.join(s))
        else:
            print('---')