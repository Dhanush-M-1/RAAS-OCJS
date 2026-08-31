t=int(input())
for j in range(t):
    # x,y,n = map(int, input().split())
    x=int(input())
    n,m=0,0
    f=0
    while(x!=1):
        if(x%2==0):
            x/=2
            n+=1
        elif(x%3==0):
            x/=3
            m+=1
        else:
            print("-1")
            f=1
            break
    if(f==0):
        if(m<n):
            print("-1")
        else:
            print(2*m-n)
        
    # a=int((n-y)/x)
    # print(a*x +y)
    # for i in range(n,-1,-1):
    #     if(i%x==y):
    #         print(i)
    #         break