from math import ceil, floor
def gcd(a, b):
    if a == 0:
        return b, 0, 1

    gc,x1,y1 = gcd(b%a, a)

    x = y1-(b//a) * x1
    y = x1
    return gc,x,y


n,p,w,d = map(int, input().split())

wd_gcd, b1, b2 = gcd(w,d)

if (p % wd_gcd != 0):
    print("-1")
else:
    fac = p//wd_gcd
    b1 *= fac
    b2 *= fac

    low_lim = -b1/(d/wd_gcd)
    hl = b2/(w//wd_gcd)
    low_lim2=(b1+b2-n)/((w-d)//wd_gcd)

    ll = max(low_lim, low_lim2)

    #print(b1, b2, fac)
    #print(ll, hl)

    done = False
    
    for t in range(ceil(ll), floor(hl) + 1):
        k = t

        if (k <= hl and b1+k*(d//wd_gcd) >= 0 and b2 - k * (w//wd_gcd) >= 0 and n - b1 - b2 + ((w-d)//wd_gcd)*k >= 0):
            print(b1+k*(d//wd_gcd), b2 - k * (w//wd_gcd), n - b1 - b2 + ((w-d)//wd_gcd)*k)
            done = True
            break
    if not done:
        print("-1")
