s=set()

def tree(l,r,a,d,cd=0):
    if(r<l):
        return
    if(l==r):
        d[l]=cd
    
    pos=l
    
    for i in range(l,r+1):
        if(a[i]>a[pos]):
            pos=i
    
    d[pos]=cd
    
    tree(l,pos-1,a,d,cd+1)
    tree(pos+1,r,a,d,cd+1)
    
    

def solve():
    n=int(input())
    
    a=list(map(int,input().split()))
    d=[0]*n
    tree(0,n-1,a,d)
    

    for i in d:
        print(i,end=" ")
        
        
    print()

    
    
if __name__ == "__main__":
    t=int(input())
    while(t>0):
        t-=1
        solve()