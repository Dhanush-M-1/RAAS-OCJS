t=int(input())
for _ in range(t):
    l,r,d=(map(int,input().strip().split()))
    if(l>d):
        print(d)
    else:
        k=r//d
        k=(k+1)*d;
        
        print(k)    
