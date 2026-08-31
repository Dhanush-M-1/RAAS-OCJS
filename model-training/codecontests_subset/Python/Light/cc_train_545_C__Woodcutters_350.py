n = int(input())
trees = []
c = 1
if n >1:
    c = 2

for i in range(n):
    a,b = map(int,input().split())
    trees.append([a,b])

for i in range(1,n - 1):
    if trees[i][1] < trees[i][0] - trees[i - 1][0]:
        c += 1
    elif trees[i][1] < trees[i + 1][0] - trees[i][0]:
        c += 1
        trees[i][0] += trees [i][1]
    else :
        pass
print(c)
