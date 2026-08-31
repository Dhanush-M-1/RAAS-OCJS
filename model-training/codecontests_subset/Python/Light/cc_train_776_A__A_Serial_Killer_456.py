l=list(map(str,input().split()))
n=int(input())
print(*l)
for i in range(n) :
    a2,b2=map(str,input().split())
    l[l.index(a2)]=b2
    print(*l)
