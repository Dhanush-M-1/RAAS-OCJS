t = int(input()) 
while t:
    t-=1
    s,c = input().split()
    s = list(s)
    n = len(s)
    c = list(c)
    s1 = s[:]
    s1.sort()
    if s < c:
        print("".join(s))
        continue
    for i in range(0, n):
        if s[i] != s1[i]:
            char = s1[i]
            for j in range(n-1,-1,-1):
                if s[j] == char:
                    s[i], s[j] = s[j], s[i]
                    break
            break
    if s < c:
        print("".join(s))
    else:
        print("---")
