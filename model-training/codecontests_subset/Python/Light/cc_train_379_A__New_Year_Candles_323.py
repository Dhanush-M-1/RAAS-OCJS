a,b = map(int,input().split())

hours = a
trash = 0

while a >= b:
    hours += a//b
    trash = a - (a//b)*b
    a = a//b + trash

print(hours)


