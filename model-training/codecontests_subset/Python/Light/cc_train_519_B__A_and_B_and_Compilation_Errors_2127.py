n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
s1 = s2 = s3 = 0
for i in range(n):
        s1 += a[i]
for i in range(n-1):
        s2 += b[i]
for i in range(n-2):
        s3 += c[i]
print(s1-s2)
print(s2-s3)