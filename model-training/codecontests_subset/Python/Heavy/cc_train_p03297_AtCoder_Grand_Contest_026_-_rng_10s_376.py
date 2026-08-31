def gcd(x,y):
    if x < y:
        tmp = y
        y = x
        x = tmp

    while x % y != 0:
        r = x % y
        x = y
        y = r
    return y

n = int(input())
x = []
for i in range(n):
    a,b,c,d = map(int,input().split())
    x.append((a,b,c,d))

def f(a,b,c,d):
    if a < b:
        print("No")
    elif b > d:
        print("No")
    elif c >= b:
        print("Yes")
    else:
        g = gcd(b,d)
        if b-g+(a%g) > c:
            print("No")
        else:
            print("Yes")

for i in range(n):
    a,b,c,d = x[i][0],x[i][1],x[i][2],x[i][3]
    f(a,b,c,d)
