a,b = map(int,input().split())
h = a
while a>=1:
    a = a/b
    h+=a
print(int(h))