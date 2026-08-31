for _ in range(int(input())) :
    n=int(input())
    ar=list(map(int,input().split()))
    br=ar.copy()
   
    ar.sort()
    a=br.index(ar[0])
    br[a]=10**9+52
    b=br.index(ar[1])
    br[b]=10*6-6

   
    if len(ar)<3 :
        print(-1)
    else :
        c=ar[0]+ar[1]
        flag=0
        ans=0
        for i in range(2,len(ar)):
             if ar[i]>=c :
                 flag=1
                 ans=ar[i]
                 break
        if flag==1 :
            c=br.index(ans)
            print(a+1,b+1,c+1)          
        else :
            print(-1)  