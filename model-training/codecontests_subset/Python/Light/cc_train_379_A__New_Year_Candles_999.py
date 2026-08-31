a,b=[int(i) for i in input().split()]
k=a
while True:
    p=a%b
    a=a//b
    if a==0: break
    k=k+a
    a=a+p
print(k)
