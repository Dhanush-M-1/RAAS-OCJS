a,b = map(int,input().split())
result = a
while True:
    if a < b:
        break
    result += a//b
    a = a//b + a%b
print(result)