

def divisores(n):
    arr = []
    u = n//2 + 1
    for i in range(2, u+1):
        if n%i == 0:
            arr.append(i)
    return arr

def divisor2(n):
    cont = 0
    while n > 0 and n%2 == 0:
        n = n//2
        cont += 1
    return cont



s = input().split(" ")
l = int(s[0])
r = int(s[1])

n = l-r+1

a = []

if n == 1:
    """
    for i in range(l, r+1):
        a += divisores(i)

    a = sorted(a)
    b = list(set(a))

    f = [0]*len(b)

    i = 0
    j = 0

    while j < len(b):
        while i < len(a) and a[i] == b[j]:
            f[j] += 1
            i += 1
        j += 1

    maximo = max(f)

    for i in range(len(f)):
        if f[i] == maximo:
            print(b[i])
            break
    """
    print(l)
else:
    print(2)

"""
2 2 -> 1
3 2 3 -> 2
4 2 3 4 -> 3
5 2 3 4 5 -> 4

n -> n


Sn = 1+2+3+4+...n = (1+n)n/2 -> O(n²)

"""

