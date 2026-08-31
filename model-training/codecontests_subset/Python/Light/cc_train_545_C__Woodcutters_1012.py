n = int(input())

trees = []
for _ in range(n):
    x,h  = map(int, input().split())
    trees.append((x,h))




ans  = 2
left = trees[0][0]
for i in range(1,len(trees)-1):
    if left < trees[i][0] - trees[i][1]:
        left = trees[i][0]
        ans += 1
    elif trees[i][0] + trees[i][1] < trees[i+1][0]:
        ans+=1
        left = trees[i][0] + trees[i][1]
    else:
        left = trees[i][0]

if n==1:
    print(1)
else:
    print(ans)

#print(dp)