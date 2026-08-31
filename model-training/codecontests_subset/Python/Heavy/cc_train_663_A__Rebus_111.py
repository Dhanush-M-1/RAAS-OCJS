ar, ans = input().split('=')
ans = int(ans)

pl = ar.count('+') + 1
mn = ar.count('-')

if pl*ans - mn*1 < ans or pl*1 - mn*ans > ans:
    print("Impossible")
    exit(0)

print("Possible")

mat = [1]*(pl+mn)

sig = ('+' + ar).replace(' ', '').split('?')
del sig[-1]

while True:
    i = 0
    s = ""
    for ch in ar:
        if ch == '?':
            s += str(mat[i])
            i += 1
        else:
            s += ch

    t = eval(s)
    if t == ans:
        print("{0}= {1}".format(s, ans))
        exit(0)

    d = ans - t

    for i in range(len(mat)):
        if sig[i] == '+' and d > 0:
            mat[i] = min(1 + d, ans)
            d -= mat[i] - 1
        elif sig[i] == '-' and d < 0:
            mat[i] = min(1 + abs(d), ans)
            d += mat[i] - 1