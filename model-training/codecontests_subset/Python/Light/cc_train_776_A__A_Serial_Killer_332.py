n1, n2 = input().split()
n = int(input())
while n > 0:
    print(n1, n2)
    s1, s2 = input().split()
    if s1 == n1:
        n1 = s2
    else:
        n2 = s2
    n -= 1
print(n1, n2)
