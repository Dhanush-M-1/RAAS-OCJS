n = int(input())
s1 = list(map(int,input().split()))
s2 = list(map(int,input().split()))
s3 = list(map(int,input().split()))

s1 = sum(s1)
s2 = sum(s2)
s3 = sum(s3)

print(s1-s2)
print(s2-s3)

