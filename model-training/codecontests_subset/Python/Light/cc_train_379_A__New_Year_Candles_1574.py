a,b = input().split(" ")
a =int(a)
b = int(b)
cnt = a
while a>=b:
    cnt =cnt + int(a/b)
    a =int(a/b)+(a%b)
print(cnt)
