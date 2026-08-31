o=int(input())
l=list(map(int,input().split()))
m=list(map(int,input().split()))
n=list(map(int,input().split()))
l.sort()
m.sort()
n.sort()
for i in range(o-1):
    if(l[i]!=m[i]):
        print(l[i])
        break
else:
    print(l[-1])
for i in range(o-2):
    if(m[i]!=n[i]):
        print(m[i])
        break
else:
    print(m[-1])
