a,b=list(map(int,input().split()))
h=a
while(a//b!=0):
    h+=a//b
    a=(a//b)+(a%b)
print(h)