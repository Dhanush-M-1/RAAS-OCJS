import math
def isPrime(n) : 
  
    # Corner cases 
    if (n <= 1) : 
        return False
    if (n <= 3) : 
        return True
  
    # This is checked so that we can skip  
    # middle five numbers in below loop 
    if (n % 2 == 0 or n % 3 == 0) : 
        return False
  
    i = 5
    while(i * i <= n) : 
        if (n % i == 0 or n % (i + 2) == 0) : 
            return False
        i = i + 6
  
    return True
l,r=map(int,input().split())
temp=0
li=[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199]
#lo=[]
if r!=l:
    print("2")
    temp=1
else:
    if isPrime(l):
        print(l)
        temp=1
    if temp==0:
        for i in range(15,1,-1):
            x=pow(l,(1/i))
            y=pow(round(x),i)
            if l == y:
                temp=1
                print(round(x))
                break
    if temp==0:
        for i in range(len(li)):
            if l%li[i]==0:
                print(li[i])
                temp=1
                break
    if temp==0:
        print(l)

    
