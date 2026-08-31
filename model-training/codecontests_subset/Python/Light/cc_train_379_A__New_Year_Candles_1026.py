a,b = map(int,input().split())

h = a

while a>=b:
    h+=int(a/b)
    a = int(a/b)+int(a%b)
print(h)
