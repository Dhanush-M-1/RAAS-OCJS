__, size = (int(item) for item in input().split())
print(size // max([int(item) for item in input().split() if size % int(item) == 0]))