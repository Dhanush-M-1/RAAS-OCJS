t = int(input())
for i in range(t):
    n = int(input())
    pp = [] 
    cc = [] 
    f = 0
    q = 0
    pp.append(0)
    cc.append(0)
    for j in range(1, n+1):
        p, c = map(int, input().split())
        pp.append(p)
        cc.append(c)
    for j in range(0, n):
        if((pp[j] > pp[j+1]) or (cc[j] > cc[j+1])):
            f = 1
            break
    for j in range(1, n+1):
        if((pp[j] - pp[j-1]) < (cc[j] - cc[j-1])):
            q = 1
            break
    if(f == 1 or q == 1):
        print("NO")
    else:
        print("YES")
