t = int(input())
flag  = True
for i in range(t):
    n = int(input())
    pk = -1
    ck = -1
    flag  = True
    if(n == 1):
        p, c = map(int, input().split())
        if(c > p):
            flag  = False
    else:
        for j in range(n):
            p, c = map(int, input().split())
            if(c > p):
                flag  = False
            elif(pk > p or ck > c):
                flag  = False
            elif(c - ck > p - pk):
                flag  = False
            pk = p
            ck = c
    if(flag):
        print("YES")
    else:
        print("NO")
        
