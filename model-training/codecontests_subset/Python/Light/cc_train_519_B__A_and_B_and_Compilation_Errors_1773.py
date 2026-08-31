input()
a=list(map(int,input().split()))
a.sort()
b=list(map(int,input().split()))
b.sort()
c=list(map(int,input().split()))
c.sort()
k=b.copy()
for i in a:
    if i not in b:
        print(i)
        break
    else:
        b.remove(i)
for i in k:
    if i not in c:
        print(i)
        break
    else:
        c.remove(i)
