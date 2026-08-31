import sys

def menseki(x0,y0,x1,y1,x2,y2):
    return 0.5*abs((x1-x0)*(y2-y0)-(x2-x0)*(y1-y0))

def square_menseki(x0,y0,x1,y1,x2,y2,x3,y3):
    return 0.5*abs((x0*y1-y0*x1)+(x1*y2-y1*x2)+(x2*y3-y2*x3)+(x3*y0-y3*x0))

for row in sys.stdin:
    x0,y0,x1,y1,x2,y2,x3,y3 = list(map(float, row.strip().split(',')))
    s = square_menseki(x0,y0,x1,y1,x2,y2,x3,y3)
    if s > menseki(x0,y0,x1,y1,x2,y2) and s > menseki(x0,y0,x1,y1,x3,y3) and s> menseki(x0,y0,x2,y2,x3,y3) and s > menseki(x1,y1,x2,y2,x3,y3):
        print('YES')
    else:
        print('NO')
    
