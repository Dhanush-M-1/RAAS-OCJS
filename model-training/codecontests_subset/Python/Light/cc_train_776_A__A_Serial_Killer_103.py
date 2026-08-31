f,s = input().split()
print(f,s)
n = int(input())
for i in range(n):
    a,b = input().split()
    if a == f:
        f = b
    elif a == s:
        s = b
    print(f,s)