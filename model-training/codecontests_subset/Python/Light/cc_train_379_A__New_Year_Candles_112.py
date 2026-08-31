a, b = map(int,input().split())
count_h = a
while a >= b:
    a -= b
    a += 1
    count_h += 1
print(count_h)