n, k = map(int, input().split())
L = list(map(int, input().split()))
a = max([x for x in L if k % x == 0])
print(k//a)