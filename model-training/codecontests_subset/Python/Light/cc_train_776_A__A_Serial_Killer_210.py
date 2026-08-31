def prin(li):
    for j in li:
        print(j, end=' ')
    print()

li = list(map(str, input().split()))
n = int(input())
prin(li)
for i in range(0, n):
    a, b = map(str, input().split())
    if a == li[0]:
        li[0] = b
        prin(li)

    if a == li[1]:
        li[1] = b
        prin(li)
