n, m = (input().split( ))
t=int(input())
print(n,m)

for i in range(t):
   
    p, q = (input().split( ))
    if n==p:
       
        print(m,q)
        n=q
    else:
        
        print(n,q)
        m=q
        
    
        