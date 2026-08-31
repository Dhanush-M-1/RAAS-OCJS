n = int(input())
if n == 1:
    print(1)
    exit()
if n == 2:
    print(2)
    exit()
alive_trees = []
for i in range(n):
    x, h = map(int, input().split())
    alive_trees.append([x, h])
answer = 2
last_killed = alive_trees[0][0]
for i in range(1, n-1):
    if alive_trees[i][0]-alive_trees[i][1] > max(last_killed, alive_trees[i-1][0]):
        answer += 1
    elif alive_trees[i][0]+alive_trees[i][1] < alive_trees[i+1][0]:
        answer += 1
        last_killed = alive_trees[i][0]+alive_trees[i][1]
print(answer)