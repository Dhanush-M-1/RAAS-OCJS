for _ in range(int(input())):
    n=int(input())
    
    a=n
    x=0
    y=0
    while(a>0):
        if(a%3==0):
            a=a//3
            y=y+1
        else:
            break
    while(1):
        if(n==1):
            break
        else:
            if(y<=0):
                x=-1
                break
            else:
                if(n%6==0):
                    n=n//6
                    x=x+1
                    y=y-1
                else:
                    n=n*2
                    x=x+1
    print(x)