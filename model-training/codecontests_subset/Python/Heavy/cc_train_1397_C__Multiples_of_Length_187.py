n = int(input())
a = list(map(int, input().split()))
# a[i] + x(n-1) = 0 mod n
# x(n-1) = (n-a[i]) mod n

def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)

def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m


if n==1:
    i = 0
    print(1,1)
    print (-1*a[i])
    print(1,1)
    print (0)
    print(1,1)
    print (0)
    exit(0)

print (1, n-1)
for i in range(n-1):
    tba = ((-a[i]%n * modinv(n-1,n))%n)*(n-1)
    a[i] += tba
    print (tba, end = ' ')
print()

print (2, n)
for i in range(1, n):
    tba = ((-a[i])%n * modinv(n-1,n))*(n-1)
    a[i] += tba
    print (tba, end = ' ')
print()

print (1,n)
for i in range(n):
    tba = a[i]*-1
    print (tba, end = ' ')
print()