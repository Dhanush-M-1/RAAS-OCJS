n = int(input())
trees = []
for i in range(n):
    trees.append(list(map(int, input().strip().split())))

pre = -float('inf')
c = 1
for i in range(n-1):
    # print(pre)
    x = trees[i][0]; h = trees[i][1]
    if x-h > pre:
        pre = x
        c += 1
    elif x+h < trees[i+1][0]:
        c += 1
        pre = x+h
    else:
        pre = x

print(c)

