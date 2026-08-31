n, k = map(int, input().split())
a = list(map(int, input().split()))
x = max(list(filter(lambda x: k%x == 0, a)))
print(k//x)