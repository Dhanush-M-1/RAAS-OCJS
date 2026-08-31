r1,r2 = list(map(int,input().split()))
c1,c2 = list(map(int,input().split()))
d1,d2 = list(map(int,input().split()))
res = True
for i in range(1,10):
    u = r1-i
    v = c1-i
    w = d1-i
    l = [i,u,v,w]
    if min(l)>=1 and len(set(l))==4 and w+v==r2 and u+w==c2 and i+v==c1 and u+i==r1 and u+v==d2 and i+w==d1 and max(l)<=9:
        print(i,u)
        print(v,w)
        res = False
        break
if res:
    print(-1)
    
