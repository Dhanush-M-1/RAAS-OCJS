
n = int(input())

A = [int(x) for x in input().split()]

print(max([min([x - 1, 10**6 - x]) for x in A]))
