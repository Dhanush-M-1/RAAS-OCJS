__author__ = "runekri3"

n = int(input())
a = list(map(int, input().split()))  # n+1
b = list(map(int, input().split()))  # n
c = list(map(int, input().split()))  # n-1
a.sort()
b.sort()
c.sort()

for b_elem in b:
    a.remove(b_elem)
    try:
        c.remove(b_elem)
    except ValueError:
        bug2 = b_elem
bug1 = a[0]
print(bug1)
print(bug2)
