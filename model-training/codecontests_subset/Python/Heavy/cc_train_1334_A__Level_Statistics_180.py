
t = int(input())
while(t>0):
    n = int(input())
    x = []
    for i in range(n):
        l = tuple(map(int,input().split()))
        x.append(l)
    maxp = 0
    maxc = 0
    for i in range(n):
        p = x[i][0]
        c = x[i][1]
        dp = p-maxp
        dc = c-maxc
        if(c>p):
            f=0
            break
        elif(maxp>p or maxc>c):
            f=0
            break
        elif(p==maxp and c>maxc):
            f = 0
            break
        elif(dc>dp and dp>0 and dc>0):
            f = 0
            break
        else:
            maxp=p
            maxc=c
            f=1
    if(f==0):
        print("NO")
    elif(f==1):
        print("YES")
    t=t-1