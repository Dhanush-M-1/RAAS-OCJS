a,b = map(int,input().strip().split())
result = a
remain = 0

while a>=b:
    remain = a % b
    result += a//b
    a = a//b + remain
print(result)