import math

(n, p, w, d) = list(map(int, input().split()))

flag = False
a = w - d
b = -d
c = p - n * d

if p == 0:
    print(0, 0, n)

elif c % math.gcd(abs(a), abs(b)) != 0:
    print(-1)

else:
    X = math.gcd(abs(a), abs(b))
    if c >= 0:
        a //= X
        b //= X
        c //= X
    else:
        a //= -X
        b //= -X
        c //= -X


    for k in range(abs(a)):
        if (c - b * k) % a == 0:
            Y = k
            X = (c - b * Y) // a
            flag = True
            break

    if flag:
        if (0 <= X <= n) and (0 <= Y <= n) and (0 <= n - X - Y <= n):
            print(X, n - X - Y, Y)
        else:
            #kmax = min((n - X) // b, (n - Y) // a)
            #kmin = max((- Y) // a, (- X) // b)
            #print((n - X) // b)
            #print((n - Y) // a)
            #print(( - X) // b)
            #print(( - Y) // a)

            if a > 0:
                amax = Y // a
                amin = (Y - n) // a
            else:
                amin = Y // a
                amax = (Y - n) // a
            if b > 0:
                bmax = (n - X) // b
                bmin = -X // b
            else:
                bmin = (n - X) // b
                bmax = -X // b

            kmin = max(amin, bmin)
            kmax = min(amax, bmax)
            if kmin < kmax:
                for k in range(kmin - 2, kmax + 2):
                    xx = X + b * k
                    yy = Y - a * k
                    if (0 <= xx <= n) and (0 <= yy <= n) and (0 <= n - xx - yy <= n):
                        print(xx, n - xx - yy, yy)
                        flag = False
                        break
                if flag:
                    print(-1)

            else:
                print(-1)
    else:
        print(-1)