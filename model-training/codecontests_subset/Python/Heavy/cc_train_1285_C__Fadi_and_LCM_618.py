def f(num1, num2, i):
    global a1, a2
    if i == len(ar):
        if max(num1, num2) < max(a1, a2):
            a1, a2 = num1, num2
        return
    kek = ar[i]
    lol = 1
    while i < len(ar) and ar[i] == kek:
        i += 1
        lol *= kek
    f(num1 * lol, num2, i)
    f(num1, num2 * lol, i)


x = int(input())
ar = []
i = 2
while i * i <= x:
    if x % i == 0:
        x //= i
        ar.append(i)
    else:
        i += 1
ar.append(x)
a1, a2 = 10 ** 12, 10 ** 12
f(1, 1, 0)
print(a1, a2)
