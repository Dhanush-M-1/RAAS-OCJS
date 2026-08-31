n = int(input())
a1 = [*map(int , input().split())]
a2 = [*map(int , input().split())]
a3 = [*map(int , input().split())]
print(sum(a1) - sum(a2))
print(sum(a2) - sum(a3))
