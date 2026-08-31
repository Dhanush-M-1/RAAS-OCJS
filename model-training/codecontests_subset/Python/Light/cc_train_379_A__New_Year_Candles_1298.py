l=input().split()
a=int(l[0])
b=int(l[1])
s=a
while a/b>=1:
    s+=int(a/b)
    a=int(a/b)+a%b
print(s)