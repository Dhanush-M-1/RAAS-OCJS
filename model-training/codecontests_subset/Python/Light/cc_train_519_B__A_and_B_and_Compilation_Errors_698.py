n = int(input())
a = list(map(int, input().split()))
a.sort()
b = list(map(int, input().split()))
b.sort()
c = list(map(int, input().split()))
c.sort()
print(sum(a) - sum(b))
print(sum(b) - sum(c))





