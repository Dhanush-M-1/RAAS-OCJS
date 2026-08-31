import math
def answer(n):
    if n==1:
        return 1
    elif n==2:
        return 2
        
    
    if n%2!=0:
        return n*(n-1)*(n-2)
    elif n<=6:
        return n*(n-1)*(n-2)//2
    
    else:
        flag=0
        if n%3==0 or (n-1)%3==0:
            flag=1
        x=(n-1)*(n-2)*(n-3)
        for i in range(n-3,0,-1):
            if flag:
                if i%3!=0 and i%2!=0:
                    return max(x,i*(n)*(n-1))
                
            else:
                if i%2!=0:
                    return max(x,i*n*(n-1))
            

n=int(input())

print(answer(n))