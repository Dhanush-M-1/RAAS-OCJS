n,s = map(int, input().split())
L = list(map(int, input().split()))
L = sorted(L)
if L[n//2] == s:
    print(0)
elif s > L[n//2]:
    res = 0
    f = 0
    for i in range(n//2,n):
        if s > L[i]:
            res += s-L[i]
        else:
            f = 1
            print(res)
            break
    if f == 0:
        print(res)
else:
    res = 0
    f = 0
    for i in reversed(range((n//2)+1)):
        if s < L[i]:
            res += L[i]-s
        else:
            f = 1
            print(res)
            break
    if f == 0:
        print(res)