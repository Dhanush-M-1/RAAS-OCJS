_, k = list(map(int, input().split()))
a = list(map(int, input().split()))
print(k // max(filter(lambda x: k % x == 0, a)))
