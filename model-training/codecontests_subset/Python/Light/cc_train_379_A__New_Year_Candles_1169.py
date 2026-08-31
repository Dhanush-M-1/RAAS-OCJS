A, B = map(int, input().split())

a, b = A, B
ans = a

while a >= b:
    ans += a //b
    a = a // b + a % b
    
print(ans)