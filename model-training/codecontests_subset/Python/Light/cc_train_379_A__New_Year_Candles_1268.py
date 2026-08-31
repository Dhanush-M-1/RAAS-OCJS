a,b=list(map(int,input().split()))
s=0
while a-b>=0:
    a-=b-1
    s+=b
print(s+a)