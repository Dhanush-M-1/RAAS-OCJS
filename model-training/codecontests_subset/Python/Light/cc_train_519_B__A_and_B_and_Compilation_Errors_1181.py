n=int(input())
a=list(map(int, input().split()))
b=list(map(int, input().split()))
c=list(map(int, input().split()))
S1=a[0]
S2=b[0]
S3=c[0]
for i in range(1,n):
    S1+=a[i]
for i in range(1,n-1):
    S2+=b[i]
for i in range(1,n-2):
    S3+=c[i]
print(S1-S2)
print(S2-S3)