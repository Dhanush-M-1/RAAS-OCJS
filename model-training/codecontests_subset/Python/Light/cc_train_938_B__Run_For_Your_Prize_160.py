n = int(input())
a = list(map(int, input().split()))

time = 0
for i in a:
    time = max(time, min(i - 1, 1000000 - i))
print(time)