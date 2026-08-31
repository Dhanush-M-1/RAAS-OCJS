n = int(input())
a = list(map(int, input().split()))
m = int(input())
x = [[a[i], i] for i in range(n)]
x.sort(key = lambda x: x[0], reverse = True)
for _i in range(m):
    k, p = map(int, input().split())
    print(sorted(x[:k], key = lambda x: x[1])[p - 1][0])
