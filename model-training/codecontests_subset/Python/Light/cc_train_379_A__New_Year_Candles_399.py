a, b = list(map(int, input().split(' ')))
l, h = 0, 0

while a > 0:
    h += a
    l += a
    a = l // b
    l -= l // b * b
    
print(h)
