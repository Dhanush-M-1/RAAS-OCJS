t=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
s=b[0]
for i in range(1,len(b)):
    s^=b[i]^c[i-1]
d=a[0]
 
for i in range(1,len(a)):
    d^=a[i]^b[i-1]
print(d)
print(s)

     