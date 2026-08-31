line=input().split()
a=int(line[0])
b=int(line[1])
n=a
m=0
while True:
    a0=a
    a=(a0+m)//b
    if a==0:
        break
    n+=a
    m=(a0+m)%b
print(n)
