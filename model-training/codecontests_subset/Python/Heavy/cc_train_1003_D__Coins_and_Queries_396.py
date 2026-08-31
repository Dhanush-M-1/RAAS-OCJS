import sys
input = sys.stdin.readline
n,q = map(int,input().split())
l = list(map(int,input().split()))
d = {}
for i in l:
    if i in d:
        d[i] += 1

    else:
        d[i] = 1

for i in range(q):
    z = d.copy()
    x = int(input())
    v = bin(x)[2:]
    b = v[::-1]
    j = 0
    ans = 0
    f = 0
    while j < len(b):
        if b[j] == "1":
            k = j
            val = 2 ** j
            while k > -1 and val > 0:
                tval = 2 ** k
                if tval in z:
                    e = z[tval]
                    u = val // tval
                    res = min(u, e)
                    ans += res
                    z[tval] -= res
                    val -= (tval * res)

                k = k - 1

            if val > 0:
                f = 1
                break

        j += 1

    if f:
        sys.stdout.write("-1\n")
        continue

    w = str(ans)
    sys.stdout.write(w+"\n")