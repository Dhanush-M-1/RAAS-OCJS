t=int(input())
while t:
    t=t-1
    x,y=0,0
    m=list(map(int,input().split(" ")))[0]
    flag=0
    #print(m)
    while m:
        m=m-1
        #print()
        p,c=list(map(int,input().split(" ")))
        #print(p,c)
        a=p-x
        b=c-y
        if a>=0:
            
            if b>=0:
                
                if a>=b:
                    x=p
                    y=c
                    flag=1
                    #print("UPDat",x,y)
                else:
                    flag=0
                    break
                    
            else:
                flag=0
                break
                
        else:
            flag=0
            break
        
    while m:
        m=m-1
        p,c=list(map(int,input().split(" ")))
        
            
    if flag==0:
        print("NO")
    else:
        print("YES")
        