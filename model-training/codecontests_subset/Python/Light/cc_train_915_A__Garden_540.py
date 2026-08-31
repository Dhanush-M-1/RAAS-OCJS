n, k = map(int, input().split())
a = list(map(int, input().split()))
mins = []
for i in a:
    if k % i == 0:
        x = k // i
        mins.append(x)
print(min(mins))
