a,b=map(int,input().strip().split())
c=a
while a>=b:
    c+=int(a/b)
    a=int(a/b)+a%b
print(c)