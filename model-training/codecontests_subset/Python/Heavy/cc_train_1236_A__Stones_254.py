def a1(a,b,c,k):
    
    while a>=1 and b>=2:
        k=k+3
        a=a-1
        b=b-2
    while b>=1 and c>=2:
        k=k+3
        b=b-1
        c=c-2
    return k    
def a2(a,b,c,l):                            
    while b>=1 and c>=2:
        l=l+3
        b=b-1
        c=c-2
    while a>=1 and b>=2:
        l=l+3
        a=a-1
        b=b-2
    return l    
t=int(input())
while t>0:
    t=t-1
    a,b,c=map(int,input().split())
    k=0
    l=0
    print(max(a1(a,b,c,k),a2(a,b,c,l)))
    