a,b=map(int,input().split())
x=0
while a>0:
    a=a-1
    x=x+1
    if x%b==0:
        a=a+1
print(x)
