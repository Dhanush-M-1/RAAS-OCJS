Read = lambda: list(map(int, input().split()))
input()
print(max(min(x-1,10**6-x) for x in Read()))