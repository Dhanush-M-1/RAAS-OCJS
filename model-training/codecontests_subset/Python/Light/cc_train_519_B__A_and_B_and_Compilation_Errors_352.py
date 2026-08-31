import sys

n = int(input())
a = [sum(map(int, input().split())) for i in range(3)]
print(a[0] - a[1])
print(a[1] - a[2])