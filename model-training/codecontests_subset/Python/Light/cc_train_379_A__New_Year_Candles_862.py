m, n = [int(i) for i in input().split()]
s = m + (m // n)
while m >= n:
    m = m % n + (m // n)
    s += m // n
print(s)