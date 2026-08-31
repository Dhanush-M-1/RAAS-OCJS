n = input()
l = [*map(int, input().split())]
j = [*map(int, input().split())]
n = [*map(int, input().split())]
print(sum(l) - sum(j))
print(sum(j) - sum(n))