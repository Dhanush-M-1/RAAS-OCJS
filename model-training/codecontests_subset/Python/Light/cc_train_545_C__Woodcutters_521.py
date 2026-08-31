n = int(input())
trees = [ tuple(map(int,input().split())) for _ in range(n)]
#trees.sort()
r = 0

for i in range(n):
    if i == 0 or  trees[i-1][0] + trees[i][1] < trees[i][0] : # can left
        #print(trees[i],'l')
        r += 1
    elif i != n-1 and trees[i][0] + trees[i][1] < trees[i+1][0]  or i == n-1: #can right
        #print(trees[i],'r')
        trees[i] = (trees[i][0]+trees[i][1],0)
        r += 1

print(r)