import math
t = int(input())
for _ in range(t):
    n = int(input())
    s = []
    for i in range(n):
        a = input()
        s.append(list(a))
    
    if s[0][1]==s[1][0]:
        if s[-1][-2]==s[-2][-1]:
            if s[-1][-2]==s[0][1]:
                print(2)
                print(n-1,n)
                print(n,n-1)
            else:
                print(0)
        else:
            if s[-1][-2]==s[0][1]:
                print(1)
                print(n,n-1)
            else:
                print(1)
                print(n-1,n)
    else:
        if s[-1][-2]==s[-2][-1]:
            if s[-1][-2]==s[0][1]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
        else:
            if s[-1][-2]==s[0][1]:
                print(2)
                print(1,2)
                print(n-1,n)
            else:
                print(2)
                print(n,n-1)
                print(1,2)
    