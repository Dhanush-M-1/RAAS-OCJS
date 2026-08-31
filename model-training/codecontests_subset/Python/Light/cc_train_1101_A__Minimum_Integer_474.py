n = int(input())
for _ in range(n):
    l, r, d = map(int, input().split())
    
    if d < l:
        print(d)
    else:
        i = max(r // d, 1)
        while l <= i * d <= r:
            i += 1
        print(i * d)