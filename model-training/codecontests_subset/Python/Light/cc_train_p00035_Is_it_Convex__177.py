import sys
import math
for line in sys.stdin:
    xa,ya,xb,yb,xc,yc,xd,yd = [float(i) for i in line.split(",")]
    
    # 図形の凸性:各頂点における外積を計算し、一つでも符号の異なるものがあれば非凸
    ab = (xb-xa,yb-ya)
    bc = (xc-xb,yc-yb)
    cd = (xd-xc,yd-yc)
    da = (xa-xd,ya-yd)
    va = da[0]*ab[1] - da[1]*ab[0]
    vb = ab[0]*bc[1] - ab[1]*bc[0]
    vc = bc[0]*cd[1] - bc[1]*cd[0]
    vd = cd[0]*da[1] - cd[1]*da[0]
    if all(map(lambda x:x/abs(x) == 1.0,[va,vb,vc,vd])) or all(map(lambda x:x/abs(x) == -1.0,[va,vb,vc,vd])):
        print("YES")
    else:
        print("NO")
