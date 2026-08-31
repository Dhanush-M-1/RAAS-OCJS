a, b, c=map(int, input().split()+[0])

while a>0:
    a =a-1
    c=c+1
    if c%b==0:
        a=a+1
print(c)