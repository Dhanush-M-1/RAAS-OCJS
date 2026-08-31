T=int(input())
i=0
while i<T:
    N=int(input())
    C2=0
    C3=0
    
    while N!=1:
        Div2=True
        Div3=True
        if N%3==0:
            N=N//3
            C3=C3+1
        else:
            Div3=False
        if N%2==0:
            N=N//2
            C2=C2+1
        else:
            Div2=False
        if Div2==False and Div3==False:
            break
    if N==1:
        if C2>C3:
            print(-1)
        else:
            print((C3-C2)+C3)
    else:
        print(-1)
        
        

    i=i+1