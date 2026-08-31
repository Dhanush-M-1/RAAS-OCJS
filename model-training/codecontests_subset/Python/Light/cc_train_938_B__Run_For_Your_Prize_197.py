n = int(input())
a = list(map(int, input().split()))
l_max = 1
r_min = 10 ** 6
for i in a:
    if (i <= 10 ** 6 // 2):
        l_max = max(l_max, i)
    else:
        r_min = min(r_min, i)
print(max(l_max - 1, 10 ** 6 - r_min))
    
        