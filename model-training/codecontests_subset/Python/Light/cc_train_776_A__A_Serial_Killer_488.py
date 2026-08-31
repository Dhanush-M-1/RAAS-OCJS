l=input().split()
n = int(input())
print(l[0],end=' ')
print(l[1])
for _ in range(n):
    x,y=input().split()
    l[l.index(x)]=y
    print(l[0],end=' ')
    print(l[1])