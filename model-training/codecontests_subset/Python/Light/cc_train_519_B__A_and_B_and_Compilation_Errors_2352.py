n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
s1=0
s2=0
s3=0
for i in range(n):
    s1+=a[i]
    if i<n-1:
        s2+=b[i]
    if i<n-2:
        s3+=c[i]
print(s1-s2)
print(s2-s3)