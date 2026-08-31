n = int(input())
a = [list(map(int, input().split())) for i in range(n)]

k = 2

for i in range(1, n - 1):
    x, h = a[i]
    
    if x - h > a[i-1][0]:
        k += 1
        
    elif x + h < a[i+1][0]:
        k += 1
        a[i][0] += h
        
if n == 1:
    print(1)

else:
    print(k)
