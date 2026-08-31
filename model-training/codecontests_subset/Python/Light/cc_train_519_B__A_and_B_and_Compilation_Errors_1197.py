
n=int(input())
a=input().split()
b=input().split()
c=input().split()
a=list(map(int,a))
b=list(map(int,b))
c=list(map(int,c))
a.sort()
b.sort()
c.sort()
b=b+[0]
c=c+[0,0]
for i in range(len(a)):
    if b[i]!=c[i]:
        s2=b[i]
        c.insert(i,b[i])

for i in range(len(a)):
    if a[i]!=b[i]:
        s1=a[i]
        b.insert(i,a[i])

print(s1)   
print(s2)


        