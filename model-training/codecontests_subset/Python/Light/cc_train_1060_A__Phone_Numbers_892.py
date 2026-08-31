n = int(input())
c = sum(map(lambda x: x == '8', input()))
print(min(n//11, c))