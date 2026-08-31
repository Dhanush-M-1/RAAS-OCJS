import sys
def gt():
    return list(map(int, input().split()))

pr = lambda x: print(*x[1])

t,=gt()

while t:
    t -= 1
    mp = []
    n ,= gt()
    for i in range(n):
        mp.append(input())
    a = int(mp[0][1]),(1,2)
    b = int(mp[1][0]),(2,1)
    c = int(mp[-1][-2]),(n,n-1)
    d = int(mp[-2][-1]),(n-1,n)


    if(c[0] == d[0]): a,b, c,d = c,d , a,b

    if a[0] == b[0]:
        if c[0] == d[0]:
            if a[0] == c[0]:
                print(2)
                pr(c); pr(d)
            else:
                print(0)
        else:
            if a[0] == c[0]:
                print(1)
                pr(c)
            else:
                print(1)
                pr(d)
    else:
        if a[0] == c[0]:
            print(2)
            pr(b); pr(c);
        else:
            print(2)
            pr(a); pr(c);
            
