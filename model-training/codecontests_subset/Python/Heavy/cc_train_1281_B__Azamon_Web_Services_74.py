t = int(input())
for i in range(t):
    s,t = map(str, input().split())
    s = list(s)
    t = list(t)
    s = list(reversed(s))
    #print(s)
    n = len(s)
    #print(s.index(min(s[:n])))
    while s[s.index(min(s[:n]))] == s[n-1] and n > 0:
        #print(s.index(min(s[:n])))
        n -= 1
        if n < 1:
            break
    #print(f"n={n}")
    if n >= 1:
        s[n-1], s[s.index(min(s[:n]))] = s[s.index(min(s[:n]))], s[n-1]

    s = list(reversed(s))
    #print(s)
    if s < t:
        print("".join(s))
    else:
        print("---")
