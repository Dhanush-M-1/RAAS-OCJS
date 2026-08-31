s = input().split()
lis = []
lis.append(" ".join(s))
n = int(input())
for i in range(n):
    m, n = input().split()
    s[s.index(m)] = n
    lis.append(" ".join(s))
for i in lis:
    print(i)