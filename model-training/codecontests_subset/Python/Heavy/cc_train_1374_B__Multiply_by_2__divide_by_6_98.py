for _ in range(int(input())):
    n=int(input())
    a=n
    
    if n==1:
        print(0)
    else:
        pow2=0
        pow3=0
        while(n%2==0 or n%3==0):
            if n%3==0:
                n/=3
                pow3+=1
            if n%2==0:
                n/=2
                pow2+=1
        
        if n!=1:
            print(-1)
            
        else:
            if pow3<pow2:
                print(-1)
                
            elif pow3==pow2:
                print(pow3)
            else:
                #a*=2**(pow3-pow2)
                print(2*pow3-pow2)
                
        
        
    
    