import sys
t=int(input())
for i in range(t):
    n=int(sys.stdin.readline())
    a=list(map(int,sys.stdin.readline().strip().split()))
    x=n//2
    g=0
    s=0
    b=0
    xx=0
    gend=0
    bend=0
    send=0
    bstart=0
    if(n<10):
        print(g,s,b)
        continue
    for j in range(x):
        if(a[j]>a[j+1]):
            gend=j
            break
    g=gend+1
    for j in range(x,gend,-1):
        if(a[j-1]>a[j]):
            xx=j-1
            break
    # print(xx)
    bend=xx
    cc=0
    for j in range(bend,gend,-1):
        cc+=1
        if(a[j-1]>a[j] and cc>g):
            b=cc
            bstart=j-1
            break
    
    # for j in range(bstart,gend,-1):
    #     if(a[j-1]>a[j]):
    #         send=j-1
    #         break
    send=bstart
    if(a[gend+1]>a[bend]):
        s=send-gend
        b=bend-send
    # print(g,s,b,"hre")
    if(s>g and b>g):
        # print(gend,send,bend,"endings")
        print(g,s,b)
    else:
        print(0,0,0)