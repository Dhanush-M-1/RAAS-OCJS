a = list(map(int,input().split()))
wynik = a[0]
b = 0
while a[0] >= a[1]:
    if a[0] % a[1] == 0:
        wynik = wynik + (a[0] / a[1])
        a[0] = a[0] / a[1]
    else:
        c = abs(a[0] % a[1] - a[1])
        if c <= b:
            a[0] = a[0] + c
            b = b - c
        b = b + (a[0] % a[1])
        if b >= a[1]:
            b = b // a[1]
            wynik = wynik + b
        wynik = wynik + (a[0] // a[1])
        a[0] = a[0] // a[1]
else:
    wynik = wynik + ((a[0] + b) // a[1])
    print(int(wynik))

