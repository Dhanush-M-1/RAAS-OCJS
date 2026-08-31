a,b=map(int,input().split())
sol=0
r=0
while True:
    sol+=a
    r+=a
    a=0
    if r>=b:
        a=int(r/b)
        r=r-int(r/b)*b
    if a==0:
        break
print(sol)

