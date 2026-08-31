n = int(input())
a = [0] * (n + 1)
b = [0] * (n + 1)
for i in range(n):
    a[i], b[i] = map(int, input().split())
c = [[0] * 2 for i in range(n + 1)]
for i in range(n):
    if i == 0:
        c[i + 1][0] = 1
        c[i + 1][1] = max(c[i][0], c[i][1]) + ((a[i] + b[i]) < a[i + 1])
    elif i == n - 1:
        c[i + 1][1] = max(c[i][0], c[i][1]) + 1
        c[i + 1][0] = max( \
            c[i][0] + (a[i - 1] < (a[i] - b[i])), \
            c[i][1] + ((a[i - 1] + b[i - 1]) < (a[i] - b[i])))                  
    else:
        #print([a[i - 1] + b[i - 1], a[i] - b[i]])
        #print([(a[i - 1] < (a[i] - b[i])), \
        #       ((a[i- 1] + b[i - 1]) < (a[i] - b[i]))])
        c[i + 1][0] = max( \
            c[i][0] + (a[i - 1] < (a[i] - b[i])), \
            c[i][1] + ((a[i - 1] + b[i - 1]) < (a[i] - b[i])))                  
        c[i + 1][1] = max(c[i][0], c[i][1]) + ((a[i] + b[i]) < a[i + 1])
"""
for i in range(2):
    print(i, end = ': ')
    for j in range(n + 1):
        print(c[j][i], end = ' ')
    print()
"""

print(max(c[n][0],c[n][1]))
