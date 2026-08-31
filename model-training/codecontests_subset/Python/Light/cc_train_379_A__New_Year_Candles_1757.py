a,b=map(int,input().split())
f=a
h=a
while f>f%b:
        h+=f//b
        f=f//b+f%b
print(h)        