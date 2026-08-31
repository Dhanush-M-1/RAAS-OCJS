n=input()
c=list()
for i in range(3):
    x=0
    a=list(map(int,input().split()))
    for r in a:
        x+=r
    c.append(x)
print(c[0]-c[1])
print(c[1]-c[2])
