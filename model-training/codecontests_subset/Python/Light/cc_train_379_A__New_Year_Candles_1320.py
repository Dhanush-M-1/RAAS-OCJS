a,b=map(int,input().split())
ans,rest=0,0
while a or rest>=b:
    ans+=a
    rest+=a
    a-=a
    a+=rest//b
    rest-=(rest//b)*b
print(ans)