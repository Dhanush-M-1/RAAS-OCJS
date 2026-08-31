n, x, y = map(int, input().split())
p = []
maxp = 0
maxi = 10**100
for i in range(n):
    x1, y1 = map(int, input().split())
    if (x - x1)**2 + (y - y1)**2 > maxp:
        maxp = (x - x1)**2 + (y - y1)**2
    p.append([x1, y1])
    
def find(x, y, x1, y1, x2, y2):
    global xres, yres
    l = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)
    pr = (x-x1)*(x2-x1)+(y-y1)*(y2-y1)
    res = True
    cf = pr/l
    if cf < 0:
        cf = 0
        res = False
    if cf > 1:
        cf = 1
        res = False
    xres = x1 + cf*(x2 - x1)
    yres = y1 + cf*(y2 - y1)

for i in range(n):
    nex = (i + 1) % n
    find(x, y, p[i][0], p[i][1], p[nex][0], p[nex][1])
    if (x - xres)*(x - xres) + (y - yres)*(y - yres) < maxi:
        maxi = (x - xres)*(x - xres) + (y - yres)*(y - yres)
print(3.141592653589793238462*(-maxi + maxp))
        
    