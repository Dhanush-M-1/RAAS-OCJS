n = int(input())
x = [0 for i in range(n)]; h = [0 for i in range(n)]
for i in range(n):
    x[i], h[i] = map(int, input().split())
if n >=2:
    fallen_trees = 2
elif n == 1 or n == 0:
    fallen_trees = n
else:
    fallen_trees = 0
for j in range(1, n-1):
    if x[j] - h[j] > x[j-1]:
        fallen_trees += 1
    elif x[j] + h[j] < x[j+1]:
        x[j] += h[j]
        fallen_trees += 1
print(fallen_trees)