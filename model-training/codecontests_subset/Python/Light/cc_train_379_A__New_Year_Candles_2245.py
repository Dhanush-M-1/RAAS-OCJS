a,b=map(int,input().split())
hr=a
while(a>=b):
    d=a//b
    hr=hr+d
    r=a%b
    a=d+r
print(hr)
