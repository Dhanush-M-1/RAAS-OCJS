t=int(input())
i=0
while i<t:
    n=int(input())
    count2=0
    count3=0
    
    while n!=1:
        div2=True
        div3=True
        if n%3==0:
            n=n//3
            count3=count3+1
        else:
            div3=False
        if n%2==0:
            n=n//2
            count2=count2+1
        else:
            div2=False
        if div2==False and div3==False:
            break
    if n==1:
        if count2>count3:
            print(-1)
        else:
            print((count3-count2)+count3)
    else:
        print(-1)
        
        

    i=i+1
