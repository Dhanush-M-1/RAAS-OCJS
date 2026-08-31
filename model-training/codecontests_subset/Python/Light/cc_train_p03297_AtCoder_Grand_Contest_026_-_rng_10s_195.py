gcd = lambda x,y: x if y==0 else gcd(y,x%y)

t = int(input())
for i in range(t):
    a,b,c,d = map(int,input().split())
    dx = d%b
    if a<b:
        print('No')
    elif d<b:
        print('No')
    elif c>=b:
        print('Yes')
    elif a%b>c:
        print('No')
    elif dx==0:
        print('Yes')
    else:
        if b - gcd(b,d) + a%gcd(b,d) > c:
            print('No')
        else:
            print('Yes')
