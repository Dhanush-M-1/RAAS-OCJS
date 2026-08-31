for i in range(int(input())):
    n=int(input())
    count=0
    if n==1:
        print(count)
    elif n<6 and n%3!=0:
        print(-1)
        
    elif n>=6 or n%3==0:
        while n!=1:
            if n>=6 and n%6==0:
                n=n//6
                #print(n)
                count+=1
            elif n>6 and n%3==0:
                n=n*2
                count+=1
            elif n<6 and n%3==0:
                n=n*2
                count+=1    
            elif n<6 and n%3==0:
                #print(n)
                n=n*2
                count+=1
            else:
                #print(n)
                print(-1)
                break
        else:    
            print(count)        
                