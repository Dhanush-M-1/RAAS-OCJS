n1, n2 = input().split()
print(n1, n2)
s = set([n1, n2])
n = int(input())
for i in range(n):
    n1, n2 = input().split()
    s -= set([n1])
    s.add(n2)
    print(*s)