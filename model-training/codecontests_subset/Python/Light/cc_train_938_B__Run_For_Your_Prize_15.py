input()

print(max(min(a-1,10**6-a) for a in map(int, input().split())))