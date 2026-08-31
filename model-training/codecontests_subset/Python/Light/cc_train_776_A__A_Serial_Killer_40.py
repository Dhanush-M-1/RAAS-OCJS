a, b = map(str, input().split())
print(a, b)
for i in range(int(input())):
    c, d = map(str, input().split())
    if a == c:
        a = d
    else:
        b = d
    print(a, b)