def gcd(a,b):
    if b==0:
        return a
    else:
        return gcd(b,a%b)

t=int(input())
result=[]
for i in range(t):
    a,b,c,d=list(map(int,input().split()))
    if b>d:
        result.append('No')
    elif a<b:
        result.append('No')
    elif a%b>c:
        result.append('No')
    elif b-c-1<gcd(b,d):
        result.append('Yes')
    else:
        result.append('No')

for r in result:
    print(r)

