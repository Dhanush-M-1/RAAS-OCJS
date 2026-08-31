a,b = [int(i) for i in input().split()]
h=0
_=0
while a:
    h+=1
    a-=1
    _+=1
    if _==b:
        _=0
        a+=1
print(h)