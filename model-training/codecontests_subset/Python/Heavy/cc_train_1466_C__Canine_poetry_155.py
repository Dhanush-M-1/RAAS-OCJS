from sys import stdin,stdout
nmbr = lambda: int(stdin.readline())
lst = lambda: list(map(int, stdin.readline().split()))
def fn(s):
    s=list(s)
    ans = i = 0
    while i < n:
        if i + 2 < n and s[i] == s[i + 1] == s[i + 2] and (s[i]!=' '):
            ans += 2
            i = i + 3
        elif i + 2 < n and s[i] == s[i + 2] and (s[i]!=' '):
            ans += 1
            s[i+2]=' '
            i = i + 1
        elif i + 1 < n and s[i] == s[i + 1] and (s[i]!=' '):
            ans += 1
            i = i + 2
        else:
            i += 1
    return ans
for _ in range(nmbr()):
    s1=input()
    n=len(s1)
    if n==2:
        if s1[0]==s1[1]:print(1)
        else:print(0)
        continue
    # print((fn(s1),fn(s1[::-1])))
    print(min(fn(s1),fn(s1[::-1])))