r1 , r2 = map(int , input().split( ) )
c1 , c2 = map(int , input().split( ) )
d1 , d2 = map(int , input().split( ) )
ans=0
for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            for d in range(1, 10):
                if a+b == r1 and c+d==r2 and a+c==c1 and b+d==c2 and a+d==d1 and b+c==d2:
                    check = [a,b,c,d]
                    check = set(check)
                    if len(check)==4:
                        print(a,b)
                        print(c,d)
                        ans = 1
                        break
if ans == 0:
    print(-1)