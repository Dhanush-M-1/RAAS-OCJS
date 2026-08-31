from sys import stdin

while(True):
    try:
        xa,ya,xb,yb,xc,yc,xd,yd = map(float, stdin.readline().split(","))
        ab = [xb-xa,yb-ya]
        bc = [xc-xb,yc-yb]
        cd = [xd-xc,yd-yc]
        da = [xa-xd,ya-yd]
        cr1 = ab[0]*bc[1] - ab[1]*bc[0]
        cr2 = bc[0]*cd[1] - bc[1]*cd[0]
        cr3 = cd[0]*da[1] - cd[1]*da[0]
        cr4 = da[0]*ab[1] - da[1]*ab[0]
        if (cr1<0 and cr2<0 and cr3<0 and cr4<0) or (cr1>0 and cr2>0 and cr3>0 and cr4>0):
            print("YES")
        else:
            print("NO")
    except:
        break

