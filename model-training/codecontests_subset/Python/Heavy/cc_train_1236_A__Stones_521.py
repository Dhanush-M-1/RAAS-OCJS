for _ in range (int(input())):
    a,b,c=map(int,input().split())
    ans=0
    while 1:
        if b==0 or (a==0 and b==0) or (b<=1 and c<=1 ) or (c<=1 and a==0) or (a==0 and c==0):
            break
        if b>c:
            while( b>1 and a>0 )and b>c:
                b-=2
                a-=1
                ans+=3
                # print(a,b,c)
            while(b>0 and c>1) and b>c:
                c-=2
                b-=1
                ans+=3
                # print(a,b,c)
        else:
            while( b>0 and c>1) and c>=b:
                c-=2
                b-=1
                ans+=3
                # print(a,b,c)
            while(b>1 and a>0) and c>=b:
                b-=2
                a-=1
                ans+=3
                # print(a,b,c)
    print(ans)