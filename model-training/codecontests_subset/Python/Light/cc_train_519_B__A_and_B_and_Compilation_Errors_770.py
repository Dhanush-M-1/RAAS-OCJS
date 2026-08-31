n= int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
s,j,k = 0,0,0
for i in range(n-1):
    if a[i]==b[i]:
        continue
    else:
        k = a[i]
        s+=1
        break
if s == 0 and k==0:
    k = a[-1]
s = 0
for i in range(n-2):
    if b[i]==c[i]:
        continue
    else:
        j = b[i]
        s+=1
        break
if s==0 and j==0:
    j = b[-1]
print(k)
print(j)
