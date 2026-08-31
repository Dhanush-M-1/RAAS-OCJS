a, b=map(int,input().split())
n=0
while a>0.1:
    n+=a
    a=a/b
print(int(n))
