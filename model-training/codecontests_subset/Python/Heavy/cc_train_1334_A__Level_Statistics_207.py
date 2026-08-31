for _ in range(int(input())):
    n = int(input())
    pp,pc = -1,-1
    ans = 1
    for i in range(n):
        if(ans):
            if(pp == -1):
                pp , pc = map(int,input().split())
                if(pc > pp):
                    ans = 0
            else:
                p,c = map(int,input().split())

                if(c > p):
                    ans = 0
                if(p < pp or c < pc):
                    ans = 0
                elif(p - pp  < c - pc):
                    ans = 0
                pp = p
                pc = c

        else:
            p,c = map(int,input().split())


    if(ans):
        print("YES")
    else:
        print("NO")
        

'''
for _ in range(int(input())):
    n,x = map(int,input().split())
    a = list(map(int,input().split()))
    extra = 0
    count = 0
    req = []
    r = []
    pre = 0
    for i in range(n):
        if(a[i] - x >= 0):
            extra += (a[i] - x)
            pre += 1
        else:
            req.append(x - a[i])

    req = sorted(req)
    for i in req:
        extra -= i
        if(extra >= 0):
            count += 1
            
    ans = pre + count
    print(ans)

'''
