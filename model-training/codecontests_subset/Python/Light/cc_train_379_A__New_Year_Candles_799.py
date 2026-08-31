a,b=map(int,input().split())
h=a
while h>1:
    h=h/b
    a=a+h
print(int(a))