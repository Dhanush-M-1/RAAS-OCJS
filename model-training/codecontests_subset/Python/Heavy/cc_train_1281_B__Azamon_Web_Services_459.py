import math, collections, sys
#input = sys.stdin.readline
for _ in range(int(input())):
    s, t = input().split()
    z = [i for i in s]
    z.sort()
    i = 0
    while i < len(s):
        if z[i] == s[i]:
            i+=1
        else:
            break
    if i != len(s):
        x = [c for c in s]
        j = len(s)-1
        while j > -1:
            if s[j] == z[i]:
                x[i], x[j] = x[j], x[i]
                break
            j-=1
        s = ''.join(x)
    if s < t:
        print(s)
    else:
        print("---")