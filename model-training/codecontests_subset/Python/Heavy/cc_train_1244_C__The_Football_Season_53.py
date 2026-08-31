x = 0; y = 0

def gcd(a, b):
#{
    global x, y
    if (a == 0):
    #{
        x = 0; y = 1;
        return b;
    #}
    d = gcd(b%a, a);
    t = x
    x = y - (b // a) * x;
    y = t;
    return d;
#}

#int main()
#{
#ios_base::sync_with_stdio(0); in.tie(0);
#I n, p, w, d, dd, ww;
#in >> n >> p >> w >> d;
n, p, w, d = map(int, input().split())
gc = gcd(d, w);
dd = x; ww = y
g = w * d // gc;
if (p % gc):
    print(-1); exit(0)
dd *= p // gc;
ww *= p // gc;
if (ww < 0):
#{
    di = (-ww + g // w - 1) // (g // w);
    ww += g // w * di;
    dd -= g // d * di;
    if (dd < 0):
        print(-1); exit(0)
#}
elif (dd < 0):
#{
    di = (-dd + g // d - 1) // (g // d);
    dd += g // d * di;
    ww -= g // w * di;
    if (dd < 0):
        print(-1); exit(0)
#}
if (ww < 0 or dd < 0):
    print(-1); exit(0)
di = dd // (g // d);
dd -= g // d * di;
ww += g // w * di;
if (ww + dd <= n):
    print(ww, dd, n - ww - dd)
else:
    print(-1);
#}