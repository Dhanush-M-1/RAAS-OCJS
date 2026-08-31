n = int(input())
a = list(map(int, input().split()))
s = sum(a)
for _ in range(2):
    a = list(map(int, input().split()))
    s1 = sum(a)
    print(s-s1)
    s = s1
