a, b = map(int, input().split())
hrs = a
while a//b!=0:
    hrs+=a//b
    a = a//b + a%b
print(hrs)
