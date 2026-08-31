n=int(input())

l1=list(map(int,input().split()))
s1=sum(l1)

l2=l1=list(map(int,input().split()))
s2=sum(l2)

l3=l1=list(map(int,input().split()))
s3=sum(l3)

print(abs(s2-s1))
print(abs(s3-s2))