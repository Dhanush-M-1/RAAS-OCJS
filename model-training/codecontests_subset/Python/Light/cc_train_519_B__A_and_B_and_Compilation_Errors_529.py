n=int(input())
a=[int(a) for a in input().split()]
b=[int(b) for b in input().split()]
c=[int(c) for c in input().split()]
a.sort();b.sort();c.sort()
for i in range(n):
    b.append(-1)
    if a[i]!=b[i]:
        print(a[i])
        break
for i in range(n-1):
    c.append(-1)
    if b[i]!=c[i]:
        print(b[i])
        break
# print(i for i in (set(a)-set(b)))
# print(int(i) for i in set(b)-set(c))
# for i in set(a)-set(b):
#     print(i)
# for i in set(b)-set(c):
#     print(i)