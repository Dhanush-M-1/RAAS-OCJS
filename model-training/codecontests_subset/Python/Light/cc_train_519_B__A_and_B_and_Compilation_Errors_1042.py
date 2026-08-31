f = lambda: map(int, input().split())
n = int(input())

s1 = sum(list(f()))
s2 = sum(list(f()))
s3 = sum(list(f()))
print(s1 - s2, s2 - s3)