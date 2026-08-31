r1, r2 = [int(x) for x in input().split()]
c1, c2 = [int(x) for x in input().split()]
d1, d2 = [int(x) for x in input().split()]
a = (d1 - r2 + c1)//2
b = d1 - a
c = r1 - a
d = c1 - a
ans = [a,b,c,d]

if len(set(ans))==4:
    f = 0
    for i in ans:
        if i<=0 or i>9:
            print("-1")
            f = 1 
            break 
    if f==0:
        print(a,c)
        print(d,b)
else:
    print("-1")