t = int(input())
for test in range(t):
    x = int(input())
    x1 = x
    c2 =0
    c=0
    while(x1>0):
        if(x1%3==0):
            x1 = int(x1/3)
            c2 = c2+1
        else:
            break
    
    while(True):
        if(x==1):
            break
        else:
            if(c2<=0):
                c=-1
                break
            else:    
                if(x%6==0):
                    x=int(x/6)
                    c=c+1
                    c2=c2-1
                else:
                    x=x*2
                    c=c+1
    print(c)