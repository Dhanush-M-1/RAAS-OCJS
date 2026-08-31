import time
from collections import deque 

def inpt():
    return int(input())
def inpl():
    return list(map(int,input().split()))
def inpm():
    return map(int,input().split())
    
def solve():
    n,m = inpm()
    l = inpl()
    q = inpl()
    
    d={}
    for i in l:
        d[i]=1
    for i in q:
        if i in d:
            print("YES")
            print(1,i)
            return
    print("NO")
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
    