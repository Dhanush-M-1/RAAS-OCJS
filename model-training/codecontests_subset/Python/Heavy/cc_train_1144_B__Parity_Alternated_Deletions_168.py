
n = int(input())

a = list(map(int,input().split()))

e = []
o = []

for i in  a:
    
    if i%2==0 :
        
        e.append(i)
        
    else :
        
        o.append(i)
        
if len(e) == len(o) or abs(len(e)-len(o))==1 :
    
    print(0)

elif len(e)<len(o) :
    
    e.sort(reverse=True)
    o.sort(reverse=True)
    
    s = len(e)
    
    ans = sum(o[s+1:])
    print(ans)
    
    
else :
    e.sort(reverse=True)
    o.sort(reverse=True)
    
    s = len(o)
    ans = sum(e[s+1:])
    
    print(ans)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    