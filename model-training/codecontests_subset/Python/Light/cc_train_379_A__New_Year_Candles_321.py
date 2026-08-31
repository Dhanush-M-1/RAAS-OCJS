a,b = list(map(int, input().split()))
c=0
while a!=0:
    c=c+1
    if c%b==0:
        a=a+1
    a=a-1
print(c)