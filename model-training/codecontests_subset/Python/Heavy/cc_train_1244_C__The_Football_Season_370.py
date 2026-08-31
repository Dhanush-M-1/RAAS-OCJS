import math
n,p,w,d = [int(i) for i in input().split()]
g = math.gcd(w, d)
if p % g != 0:
    print(-1)
    exit()

ww = w // g
dd = d // g
pp = p // g


aa, bb = w, d
k = []

while bb != 0:
    kk = aa // bb
    k.append(kk)
    temp = aa % bb
    aa = bb
    bb = temp

# print(k)

tups = [[1,0], [0, 1]]
for i in range(len(k)):
    nex = [0, 0]
    nex[0] = tups[-2][0] - k[i] * tups[-1][0]
    nex[1] = tups[-2][1] - k[i] * tups[-1][1]
    tups.append(nex)

# print(tups)


x0 = tups[-2][0] * pp
y0 = tups[-2][1] * pp


# if x0 * ww + y0 * dd != pp:
#     1//0

bigt = y0 // ww


y1 = y0 - bigt * ww
x1 = x0 + bigt * dd

y2 = y1 
x2 = x1 

if x2 + y2 > n or x2 < 0:
    # oldt = bigt
    # for i in range(-100000, 100000):
    #     bigt = oldt + i
    #     y1 = y0 - bigt * ww
    #     x1 = x0 + bigt * dd

    #     y2 = y1 * g
    #     x2 = x1 * g
    #     # if x2 * w + y2 * d != p:
    #     #     1//0

    #     if x2 >= 0 and y2 >= 0 and x2 + y2 <= n:
    #         print(x2, y2, n - x2 - y2)
    #         exit()
    
    
    
    
    
    
    print(-1)
else:
    if x2 * w + y2 * d != p:
        1//0
    if y2 < 0 or x2 < 0:
        while True:
            pass
    
    
    
    print(x2, y2, n - x2 - y2)