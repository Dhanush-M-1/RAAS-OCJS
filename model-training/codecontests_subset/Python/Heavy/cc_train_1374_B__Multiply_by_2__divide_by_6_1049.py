t=int(input())
for _ in range(t):
    n=int(input())
    # x,y,n=list(map(int,input().split()))
    to=0
    th=0
    notFound=True
    k=n
    l=n
    while(notFound and k>0):
        if(k%2!=0):
            notFound=False
        else:
            to+=1
            k/=2   
    notFound=True 
    while(notFound and l>0):
        if(k%3!=0):
            notFound=False
        else:
            th+=1
            k/=3    
    # print("hihihihihihihihihihihihih",end=" ")
    if((2**to)*(3**th)!=n):
        print(-1)
    else:
        if(to>th):
            print(-1)
        else:
            print(th-to+th)