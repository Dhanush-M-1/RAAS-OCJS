r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
f=False
mn=set()
for a11 in range(1,10):
    for a12 in range(1,10):
        for a21 in range(1,10):
            for a22 in range(1,10):
                mn={a11,a12,a21,a22}
                if(a11+a12 == r1)and(a21+a22==r2)and(a11+a21 == c1)and(a12+a22==c2)and(a11+a22==d1)and(a12+a21==d2)and(len(mn)==4):
                    print(a11,a12)
                    print(a21,a22)
                    f=True
                    break
if not f:
    print(-1)
                
                

# Sun Oct 11 2020 14:04:26 GMT+0300 (Москва, стандартное время)
