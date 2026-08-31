import math


def solve(n, p, w, d):
    a = math.gcd(w, d)
    if(p==0):
        return 0,0,n
    if(p % a) != 0:
        return None, None, None
    else:
        p = p//a
        w = w//a
        d = d//a
        mm = p//w  # wins
        
        while(mm >= 0):
            wp = mm*w
            if(p-wp) % d == 0:
                dd = (p-wp)//d  # draws
                if(dd+mm > n):
                    return None, None, None
                else:
                    return mm, dd, n-mm-dd
                

            mm -= 1


n1, p1, w1, d1 = map(int, input().split())
stat = solve(n1, p1, w1, d1)
# print(stat)
if stat is None:
    print(-1)
elif stat[0] is None:
    print(-1)
else:
    x=[str(zz) for zz in stat]
    print(" ".join(x))
