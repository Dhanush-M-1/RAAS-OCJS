n = int(input())
l1 = [int(n) for n in input().split()]
l2 = [int(m) for m in input().split()]
l3 = [int(p) for p in input().split()]
s1 = sum(l1)
s2 = sum(l2)
s3 = sum(l3)
print(s1-s2)
print(s2-s3)