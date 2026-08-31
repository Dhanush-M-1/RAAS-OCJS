a,b=map(int,input().split())
h=a
l=a
d=0
while l>=b:
    d=l%b
    l=l//b
    h+=l
    l=d+l
print(h+l//b)