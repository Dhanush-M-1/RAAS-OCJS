a, b = map(int, input().split())
print(b // max(filter(lambda x: b % x == 0, map(int, input().split()))))