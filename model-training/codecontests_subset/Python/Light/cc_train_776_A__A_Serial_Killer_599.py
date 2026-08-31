a= list(input().split())
print(*a)
for _ in range(int(input())):
    c,d = input().split()
    a.remove(c)
    a.append(d)
    print(*a)
