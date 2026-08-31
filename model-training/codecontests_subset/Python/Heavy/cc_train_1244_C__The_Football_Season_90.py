def gcd(a, b):
    if b:
        return gcd(b, a % b);
    return a;

def euclid(a, b):
    if b == 1:
        return [0, 1];
    f = euclid(b, a % b);
    return [f[1], f[0] - a // b * f[1]];

n, p, w, d = map(int, input().split());
g = gcd(p, gcd(d, w));
p //= g;
d //= g;
w //= g;
if (gcd(d, w) > 1):
    print(-1);
    exit(0);
f = euclid(w, d);
k = f[:];
f[0] += d;
f[1] -= w;
f[0] *= p;
f[1] *= p;
c = f[0] // d;
f[0] -= c * d;
f[1] += c * w;
k[0] -= d;
k[1] += w;
k[0] *= p;
k[1] *= p;
cc = k[1] // w;
k[0] += cc * d;
k[1] -= cc * w;
if (f[1] >= 0 and f[0] + f[1] <= n):
    print(f[0], f[1], n - f[0] - f[1]);
elif (k[0] >= 0 and k[0] + k[1] <= n):
    print(k[0], k[1], n - k[0] - k[1]);
else:
    print(-1);