k=1
n=int(input())
for i in range(1,n+1):
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    else:
        print((r//d+1)*d)
    
        
        
        
    
