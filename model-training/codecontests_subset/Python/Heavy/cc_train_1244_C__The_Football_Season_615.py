def gcd(a,b):
    return a if b==0 else gcd(b,a%b)
def exgcd(a,b):
    global x,y
    if b==0:
        x = 1
        y = 0
        return
    exgcd(b,a%b)
    x1 = x
    y1 = y
    x = y1
    y = x1 - a//b*y1
def main():
    n,p,w,d = map(int,input().split(' '))
    g = gcd(w,d)
    w//=g
    d//=g
    if p%g!=0:
        print("-1")
        return
    p//=g
    global x,y
    exgcd(w,d)
    x = x * p
    y = y * p
    if y < 0:
        delta = -y
        g = delta // w + (1 if delta%w!=0 else 0)
        y = y + g * w
        x = x - g * d
    else:
        delta = y
        g = delta // w
        y = y - g * w
        x = x + g * d
    if x + y > n or x < 0:
        print("-1")
        return
    else:
        print(int(x),int(y),int(n-x-y))
main()






