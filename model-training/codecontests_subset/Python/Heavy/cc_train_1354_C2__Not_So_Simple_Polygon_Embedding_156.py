import math

def rotate(p, angle):
    ox, oy = 0, 0 
    px, py = p[0], p[1]

    qx = ox + math.cos(angle) * (px - ox) - math.sin(angle) * (py - oy)
    qy = oy + math.sin(angle) * (px - ox) + math.cos(angle) * (py - oy)
    
    return [qx, qy]

def get(P, angle):
    P_  =  [rotate(p, angle) for p in P]
    minX, minY, maxX, maxY = float('inf'), float('inf'), -float('inf'), -float('inf')
    
    for x, y in P_:
        if x < minX:
            minX = x
        if x > maxX:
            maxX = x
        if y < minY:
            minY = y
        if y > maxY:
            maxY = y
            
    return max(maxX-minX, maxY - minY)        

def solve():
    n     = int(input())
    N     = 2 * n
    pi    = math.pi
    alpha = pi / n
    r     = 0.5 / math.sin(alpha / 2)

    P  = [[r * math.cos(2 * pi * i / N), r * math.sin(2 * pi * i / N)] for i in range(N)] 

    l, r  =  0, pi / (2*n)

    while r - l > 1e-8:
        md1  =  l + (r - l) / 3
        md2  =  r - (r - l) / 3

        if get(P, md1) < get(P, md2):
            r  = md2
        else:
            l  = md1
        
    print(get(P, (l+r) / 2))

for _ in range(int(input())):
    solve() 