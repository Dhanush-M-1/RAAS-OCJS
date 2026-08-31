a,b=map(int,input().split())
r=l=0
while a:r+=a;a,l=(a+l)//b,(a+l)%b
print(r)