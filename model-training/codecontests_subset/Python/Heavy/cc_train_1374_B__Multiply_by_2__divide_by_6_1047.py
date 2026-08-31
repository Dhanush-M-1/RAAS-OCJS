t=int(input())
for i in range(t):
    n=int(input())
    cnt=0                            
    if(n!=1 and n%3!=0):            
        print(-1)                   
        continue                    
    while(n>2):                     
        if(n%6==0):                 
            n//=6                   
            cnt+=1             
            if(n%3!=0):
                break
        else:
            n*=2
            cnt+=1 
    if(n==1):
        print(cnt)
    else:
        print(-1)