q = int(input())
for _ in range(q):
    l,r,d = map(int,input().split())
    m = l/d
    z = r//d
    if(m>1):
        print(d)
    else:
        print(d*(z+1))
            
        
