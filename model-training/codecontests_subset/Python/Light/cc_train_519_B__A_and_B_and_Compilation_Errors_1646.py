a=int(input())
b=list(map(int,input().split()))
c=list(map(int,input().split()))
d=list(map(int,input().split()))

x=sum(b)-sum(c)
y=sum(c)-sum(d)

print(x)
print(y)
