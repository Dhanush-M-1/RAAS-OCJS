n=int(input())
a=list(map(int,input().split()))
p=a.count(100)
q=a.count(200)
if p>0 and q==0:
    if p%2==0:
        print("YES")
    else:
        print("NO")
elif q>0 and p==0:
    if q%2==0:
        print("YES")
    else:
        print("NO")
else:
   

    if p>q:
        z=2*q
        k=1*p
        if z==k or (z%2==0 and k%2==0):
            print("YES")
        else:
            print("NO")
    elif q>p:
        z=2*q
        k=1*p
        if z==k or (z%2==0 and k%2==0):
            print("YES")
        else:
            print("NO")
    else:
        
        
        if p%2==0:
            print("YES")
        else:
            print("NO")
    
