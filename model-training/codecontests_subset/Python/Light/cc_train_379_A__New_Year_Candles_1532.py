a,b=map(int,input().split())
l=0
s=0
l+=a
s+=a
while s>=b:
    c=s
    s-=int(c/b)*b
    l+=int(c/b)
    s+=int(c/b)
print(l)