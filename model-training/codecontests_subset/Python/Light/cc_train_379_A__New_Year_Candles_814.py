a,b=input().split()
a=int(a)
b=int(b)
counter=a
while a >= b:
    counter+=int(a/b)
    a=a%b+int(a/b)
print(counter)
