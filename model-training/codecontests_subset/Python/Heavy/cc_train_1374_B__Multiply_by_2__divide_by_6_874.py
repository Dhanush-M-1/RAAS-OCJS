import math
from collections import deque 

def inpt():
    return int(input())
def inpl():
    return list(map(int,input().split()))
def inpm():
    return map(int,input().split())
    
def solve():
    n = inpt()
    x = 0
    y=0
    while n%2==0:
        n=n/2
        x+=1
    while n%3==0:
        n=n/3
        y+=1
    if n>1:
        print(-1)
        return
    if x>y:
        print(-1)
        return
    else:
        print(2*y-x)
    
    
    
def main():
    #start_time=time.time()
    m=10**9+7
    t = int(input())
    while(t):
        t-=1
        solve()
        
    
    #print('Time Elapsed = ',time.time()-start_time," seconds")
if __name__ == "__main__":
    main()
    