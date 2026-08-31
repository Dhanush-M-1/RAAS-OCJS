n = int(input())
c1 = list(map(int ,input().split()))
c2 = list(map(int ,input().split()))
c3 = list(map(int ,input().split()))

a = sum(c1)
b = sum(c2)
c = sum(c3)

print(a-b)
print(b-c)