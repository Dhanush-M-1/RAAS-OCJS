import sys
input=sys.stdin.readline

def calc1(r1,r2,c1,c2):
    if((r1+c1)%2==1):
        return(0)
    return(r2-r1)

def calc2(r1,r2,c1,c2):
    diff=(r2-c2)-(r1-c1)
    if((r1+c1)%2==0):
        return(diff//2)
    return((diff+1)//2)

t=int(input())
for _ in range(t):
    n=int(input())
    r=list(map(int,input().split()))
    c=list(map(int,input().split()))
    points=[(1,1)]+sorted(zip(r,c),key=lambda x:x[0])
    
    #from point (r1,c1) it is possible to visit (r2,c2) (r2>r1) (also c2>c1 otherwise no path possible) iff  (deviaition,c2-c1 <=(moves,r2-r1) or r1-c1<=r2-c2)
    #If r1-c1=r2-c2,t here is an activated path for above with cost 0: iff r1+c1 is odd(as both r and c incremented by 1 and difference stays the same). Otherwise, **each** step we need to make a swap to stay on the same difference, so the cost is r2-r1.
    #If r2-c2>r1-c1, we need to use mixture of both type of moves, the order of which doesn't matter(and doesn't affect answer as well). First go to (r_int,c_int) such that r_int-c_int=r2-c2.
    #We need (r2-c2)-(r1-c1) moves. We go to smallest such point possible, (r2-r1+1,c2-c1+1)(i.e. starting from (1,1)) Cost is 0 iff r1+c1 is even otherwise it is (r2-c2)-(r1-c1)
    #From (r_int,c_int) to (r2,c2) cost calculated using first two steps.

    ans=0
    for i in range(1,n+1):
        r1=points[i-1][0]
        r2=points[i][0]
        c1=points[i-1][1]
        c2=points[i][1]
        if((r2-c2)-(r1-c1)):
            ans+=calc2(r1,r2,c1,c2)
        else:
            ans+=calc1(r1,r2,c1,c2)
    print(ans)
    
            
