a,b=map(int,input().split())
i=0
s=b
while a>0:
    a -= 1
    i += 1
    if i==b:
        a += 1
        b += s
print(i)