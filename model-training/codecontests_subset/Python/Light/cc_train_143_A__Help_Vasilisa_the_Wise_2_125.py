import math
 
y = [int(i) for i in input().split()]
r2 = y[0]
r1 = y[1]
 
 
y = [int(i) for i in input().split()]
c1 = y[0]
c2 = y[1]
 
 
y = [int(i) for i in input().split()]
d1 = y[0]
d2 = y[1]
 
 
for i in range(1,10):
    a = i
    b = r2-i
    c = c1-i
    d = d1-i
    set1 = {a,b,c,d}
    if(len(set1)!=4): continue;
    if(max({a,b,c,d})>9): continue;
    if(min({a,b,c,d})<1): continue;
    if(r1==c+d and c2==b+d and d2==b+c):
        print(a,b)
        print(c,d)
        exit()
 
 
    
print(-1)
 
