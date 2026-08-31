import time
from collections import deque 

def inpt():
    return int(input())
def inpl():
    return list(map(int,input().split()))
def inpm():
    return map(int,input().split())
    
def solve():
    n = inpt()
    l = inpl()
    if(l[0]+l[1]<=l[-1]):
        print(1,2,n)
        return
    else:
        print(-1)
        return
    
    
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
    