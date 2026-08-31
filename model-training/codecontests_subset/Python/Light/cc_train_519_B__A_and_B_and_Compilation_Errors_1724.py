n = input()

l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
l3 = list(map(int, input().split()))

s1 = sum(l1)
s2 = sum(l2)
s3 = sum(l3)

print(s1 - s2)
print(s2 - s3)


