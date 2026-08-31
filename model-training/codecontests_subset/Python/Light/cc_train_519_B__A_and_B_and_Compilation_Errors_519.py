n = int(input())
a = [int(a) for a in input().split()]
b = [int(b) for b in input().split()]
c = [int(c) for c in input().split()]
for i in (a, b, c):
        i.sort()
#print(a, b, c)
ans1 = n-1
ans2 = n-2
for i in range(n-1):
        if a[i] != b[i]:
                ans1 = i
                break
for i in range(n-2):
        if b[i] != c[i]:
                ans2 = i
                break
print(a[ans1])
print(b[ans2])
