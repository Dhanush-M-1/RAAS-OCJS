from sys import stdin

n = int(input())
trees = []
cnt = 2
for i in range(n):
    x,h = map(int, input().split())
    trees.append([x,h])
bound = trees[0][0]
for i in range(1, n-1):
    if trees[i][0]-trees[i][1] > bound:
        cnt+=1
        bound = trees[i][0]
    elif trees[i][0] + trees[i][1] < trees[i+1][0]:
        cnt+=1
        bound = trees[i][0] + trees[i][1]
    else:
        bound = trees[i][0]
if n == 1:
    print(1)
else:
    print(cnt)
