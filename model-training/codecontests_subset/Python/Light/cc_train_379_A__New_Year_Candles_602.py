a, b = map(int, input().split())
hour = a
k = 0
c = 0
d = 0
e = 0
while a > 0:
    d = a
    e = b
    c = d % e
    k = a // b
    a = c + k
    hour = hour + k
    if k == 0:
        break
print(hour)
