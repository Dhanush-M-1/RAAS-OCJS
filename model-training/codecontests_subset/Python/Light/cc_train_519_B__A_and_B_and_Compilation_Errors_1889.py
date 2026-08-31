n= int(input(""))
a=list(map(int, input().split()))
a.sort()
b=list(map(int, input().split()))
b.sort()
c=list(map(int, input().split()))
c.sort()
for i in b:
    a.remove(i)
for j in c:
    b.remove(j)
print(a[0])
print(b[0])