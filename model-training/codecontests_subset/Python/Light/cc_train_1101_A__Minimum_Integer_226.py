for _ in range(int(input())):
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    else:
        ans=r//d
        #print(ans)
        print(d*(ans+1))