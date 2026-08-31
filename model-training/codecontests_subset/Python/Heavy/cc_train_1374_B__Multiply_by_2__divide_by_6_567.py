for i in range(int(input())):
    s=input()
    l=list(map(int,s.split()))
    p=int(s)
    c=0
    if(sum(l)==1):
        print(0)

    elif(sum(l)%3==0):
        while(p>1):
            if(sum(l)%3==0 and p%2==0):
                p=int(p/6)
                c=c+1
                l=list(map(int,str(p).split()))
            elif(sum(l)%3==0 and p%2!=0):
                p=p*2
                c=c+1
                l=list(map(int,str(p).split()))
            else:
                print(-1)
                break
        if(p==1):
            print(c)
    else:
        print(-1)
