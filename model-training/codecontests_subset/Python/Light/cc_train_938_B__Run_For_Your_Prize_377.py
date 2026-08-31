n = int(input())
a = list(map(int,input().split()))
time = 0
for p in a:
    time = max(time,min(p-1,1000000-p))
print(time)