for _ in range(int(input())):
    n=int(input())
    flag=0
    if n==1:
        c=0
    else:
        c=0
        while(n!=1):
            #print("*")
            if n%6==0:
                c+=1
                n=n//6
            else:
                n*=2
                if n%6==0:
                    c+=1
                    
                    #print("**")
                    continue
                else:
                    #print("***")
                    flag=1
                    break
                    
    if flag==1:
        print(-1)
    else:
        print(c)
            
        