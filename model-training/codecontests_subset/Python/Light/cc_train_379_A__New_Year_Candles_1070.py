a, b = map(int, input().split())
n = a
p = a
y = 0
while n > b:
    x = n // b
    p += x
    n = x + n % b 
print(p + n // b)