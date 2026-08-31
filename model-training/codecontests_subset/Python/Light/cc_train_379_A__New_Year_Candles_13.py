a, b = [int(i) for i in input().split()]

res = 0
k = 0

while a > 0:
    res += a
    a, k = (a + k) // b, (a + k) % b

print(res)
    
    
