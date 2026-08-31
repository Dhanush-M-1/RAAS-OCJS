import math
def nat(n):
    if math.floor(n)==n and n>0:
        return True
    else:
        return False
def two(n):
    count=0
    while(1):
        if n%2==0:
            count+=1
            n//=2
        else:
            return count
def three(n):
    count=0
    while(1):
        if n%3==0:
            count+=1
            n//=3
        else:
            return count

t=int(input())
for _ in range(t):
    n=int(input())
    #l=list(map(int,input().split()))
    
    if nat(math.log(n,3)):
        print(int(2*math.log(n,3)))
    elif nat(math.log(n,6)):
        print(int(math.log(n,6)))
    elif two(n)<=three(n):
        m=n
        m//=2**(two(n))
        m//=3**(three(n))
        if m==1:
            print(int(2*three(n)-two(n)))
        else:
            print(-1)
    else:
        print(-1)
    #print('CASE ',_+1,' DONE')
        
        
        
        
        
    
    