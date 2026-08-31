n = int(input())
a = list(map(int, input().split()))
a.sort()
for i in a:
    for j in a:
        if abs(i-j)%(n-1) == 0 and i != j:
            print(i, j)
            quit()
