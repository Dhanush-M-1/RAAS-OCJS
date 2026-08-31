n = int(input())
er1 = list(map(int, input().split()))
er2 = list(map(int, input().split()))
er3 = list(map(int, input().split()))

print(sum(er1) - sum(er2))
print(sum(er2) - sum(er3))
