r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2= map(int,input().split())

l = [r1,r2,c1,c2,d1,d2]
if len({r1+r2,c1+c2,d1+d2}) != 1:
    print(-1)
else:
    a = (r1-c2+d1)//2
    b = r1-a
    c = c1-a
    d= d1-a
    s = len({a,b,c,d})
    if (a >0 and a<=9) and (b >0 and b<=9) and (c >0 and c<=9) and ( d >0 and d<=9): 
        if s == 4 :
            print(a,b)
            print(c,d)
        else:
            print(-1)
    else:
        print(-1)
