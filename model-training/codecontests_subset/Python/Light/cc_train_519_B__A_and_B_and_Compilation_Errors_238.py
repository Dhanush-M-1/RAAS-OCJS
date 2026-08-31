n = int(input())
s1 = 0
s2 = 0
s3 = 0
for x in input().split():
    s1 += int(x)
for x in input().split():
    s2 += int(x)
for x in input().split():
    s3 += int(x)
print(s1-s2)
print(s2-s3)