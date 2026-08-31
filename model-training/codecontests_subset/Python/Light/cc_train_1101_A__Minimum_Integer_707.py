n = int(input())
# n,k = map(int,input().split())
# s = input()
# m = list(map(int,input().split()))
m = [tuple(map(int,input().split())) for _ in range(n)]
for i in m:
    a = i[0] - (i[0]%i[2])
    if a > i[2] or a <= 0:
        a = i[2]
    b = (i[1]+i[2])-(i[1]%i[2])
    if a < i[0]:
        print(a)
        continue
    else:
        print(b)

