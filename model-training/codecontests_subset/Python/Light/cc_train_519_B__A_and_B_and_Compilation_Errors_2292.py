n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
S1=0
S2=0
S3=0
for x in l1 :
    S1=S1+x
for x in l2 :
    S2=S2+x
for x in l3 :
    S3=S3+x
print(S1-S2)
print(S2-S3)
