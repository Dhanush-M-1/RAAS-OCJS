import time
from collections import deque 

def inpt():
    return int(input())
def inpl():
    return list(map(int,input().split()))
def inpm():
    return map(int,input().split())
def modFact(n, p): 
    if n >= p: 
        return 0    
  
    result = 1
    for i in range(1, n + 1): 
        result = (result * i) % p  
  
    return result     
def solve():
    m=10**9+7
    n = inpt()
    x=modFact(n,m)
    print((x-pow(2,n-1)+m)%m)
    
    
def main():
    #start_time=time.time()
    solve()
        
    
    #print('Time Elapsed = ',time.time()-start_time," seconds")
if __name__ == "__main__":
    main()
    