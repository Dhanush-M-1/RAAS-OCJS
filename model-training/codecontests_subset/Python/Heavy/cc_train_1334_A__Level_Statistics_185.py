for _ in range(0, int(input())):
    n = int(input())
    p=[]
    c=[]
    for x in range(0, n):
        pc = list(map(int,input().split()))
        p.append(pc[0])
        c.append(pc[1])

    flag = 0 
    if c[0]>p[0]:
        print("NO")
    else:
        for i in range(1, n):
            if p[i]-p[i-1]<0:
                flag = 1
                print("NO")
                break
            if c[i]-c[i-1]<0:
                flag = 1
                print("NO")
                break
            if (c[i]-c[i-1])>(p[i]-p[i-1]):
                flag = 1
                print("NO")
                break
        
        if flag == 0:
            print("YES")
