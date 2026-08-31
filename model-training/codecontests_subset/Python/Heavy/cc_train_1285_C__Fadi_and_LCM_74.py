def div(x):
    a = dict()
    i = 2
    x_a = x
    while i * i <= x_a:
        if x % i == 0:
            if i in a:
                a[i] = a[i] * i
            else:
                a[i] = i
            x //= i
        else:
            i += 1
    if x != 1:
        if x in a:
            a[x] = a[x] * x
        else:
            a[x] = x
    return a


def check(i, a, x):
    b = bin(i)[2:]
    b = '0' * (len(a) - len(b)) + b
    ans = 1
    for i in range(len(a)):
        if b[i] == '1':
            ans *= a[i]
    return max(ans, x // ans)


x = int(input())
a = div(x)
ans = 10**13
b = []
for i in a:
    b.append(a[i])
for i in range(2**(len(a))):
    ans = min(ans, check(i, b, x))
print(x // ans, ans)