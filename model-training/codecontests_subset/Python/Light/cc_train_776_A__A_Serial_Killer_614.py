ls = list(map(str, input().split()))
n = int(input())
print(*ls)
for _ in range(n):
    tmp = list(map(str, input().split()))
    ls.remove(tmp[0])
    ls.append(tmp[1])
    print(*ls)
