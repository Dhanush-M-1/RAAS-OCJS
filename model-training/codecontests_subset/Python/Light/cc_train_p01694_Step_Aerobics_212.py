while 1:
    n=int(input())
    if n==0:break
    now=0
    ans=0
    l=0
    r=0
    mt=list(map(str,input().split()))
    for i in mt:
        if i=="lu":l=1
        elif i=="ru":r=1
        elif i=="ld":l=0
        elif i=="rd":r=0
        if now==0:
            if l+r==2:
                ans+=1
                now=1
        elif now==1:
            if l+r==0:
                ans+=1
                now=0
    print(ans)
