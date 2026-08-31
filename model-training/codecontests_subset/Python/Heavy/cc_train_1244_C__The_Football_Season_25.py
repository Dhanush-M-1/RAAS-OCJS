# 1244C
a = input().split()
a = list(map(int,a))
n = a[0]
p = a[1]
w = a[2]
d = a[3]
stop = False
res = -1

# тривиальная проверка
def gcd(t,q):
    r = 1
    while r > 0:
        r = t % q
        t = q
        q = r
    return t
g = gcd(w,d)
if not p%g == 0:
    stop = True
w = w//g
d = d//g
p = p//g
xw = int(p//w)+1
pp = p - xw*w
xd = 0
counter = 0
while not stop:
    counter += 1
    xw -= 1
    if xw < 0:
        stop = True
        res = -1
    pp += w
    xd = pp // d
    if d*xd == pp: 
        if xw + xd <= n:
            stop = True
            res = 1
    if counter > d:
        stop = True
if res == -1:
    print(-1)
else:
    print(xw,xd,n - xw - xd)