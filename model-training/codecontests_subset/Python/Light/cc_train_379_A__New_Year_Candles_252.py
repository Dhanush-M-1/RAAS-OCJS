a,b=map(int,input().split())
h=0
while a>0:
    h=h+1
    a=a-1
    if h%b==0:
        a=a+1
print(h)
