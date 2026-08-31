'''input
13 6
10 9
6 13
'''
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

r = r1+r2
c = c1+c2
d = d1+d2
sol = True
if(r != c or c != d or d != r):
    print(-1)
    sol = False


if(sol):
    x = (d1+c1-r2)//2
    y = (d2+c2-r2)//2
    a = (d2+c1-r1)//2
    b = (d1+c2-r1)//2

    s = {x,y,a,b}
    if(len(s) < 4 or x > 9 or y > 9 or a > 9 or b > 9 or x < 1 or y < 1 or a < 1 or b < 1):
        print(-1)
    else:
        print(x,y)
        print(a,b)




