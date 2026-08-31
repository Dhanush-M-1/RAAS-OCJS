a, b = map(int, input().split())
r = a
while a >= b:
    r += int(a/b)
    a = int(a/b)+a%b
print(int(r))