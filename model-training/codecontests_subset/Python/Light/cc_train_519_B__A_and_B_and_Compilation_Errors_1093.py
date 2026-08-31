n = int(input())
a = map(int, input().split())
b = map(int, input().split())
c = map(int, input().split())
asum = sum(a)
bsum = sum(b)
csum = sum(c)
r1 = asum - bsum
r2 = bsum - csum
print(r1, r2)
