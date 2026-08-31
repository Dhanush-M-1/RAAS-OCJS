a = list(map(str, input().split()))
n = int(input())
print(*a)
for i in range(n):
    died, replaced = map(str, input().split())
    if a[0] == died:
        a[0] = replaced
    else:
        a[1] = replaced
    print(*a)