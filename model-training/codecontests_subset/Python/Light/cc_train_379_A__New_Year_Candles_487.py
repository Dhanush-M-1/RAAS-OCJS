a, b = map(int, input().split())
answer = a
while a >= b:
    answer += a // b
    a = a % b + a // b
print(answer)