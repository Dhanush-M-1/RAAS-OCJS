from collections import Counter
n=int(input())
a=Counter(map(int,input().split()))
b=Counter(map(int,input().split()))
c=Counter(map(int,input().split()))
#print(a,b,c)
for x in a.keys():
    if(x not in b or a[x]!=b[x] ):
        print(x)
        break
for x in b.keys():
    if( x not in c or b[x]!=c[x]):
        print(x)
        break
    