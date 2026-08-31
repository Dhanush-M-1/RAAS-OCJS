t=int(input(""))
while t>0:
    n=int(input(""))
    threecount=twocount=0
    flag=0
    ans=1
    while(n>1):
        if(n%3==0 or n%2==0):
            if(n%3==0):
                n=n//3
                threecount+=1
            if(n%2==0):
                n=n//2
                twocount+=1
        else:
            ans=-1
            flag=1
            break
    if(flag==0):
        if(twocount>threecount):
            ans=-1
        else:
            ans=threecount+(threecount-twocount)
    print(ans)        
            
                
            
        
    t-=1