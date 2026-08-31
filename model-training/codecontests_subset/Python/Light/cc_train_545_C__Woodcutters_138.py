n = int(input())
trees = [[int(x)for x in input().split()]for i in range(n)]
location = [trees[i][0] for i in range(n)]
height = [trees[i][1] for i in range(n)]

if n == 1:
    print(1)
    exit()

down = 2
for i in range(1, n-1):
    if location[i] - height[i] > location[i-1]:
        down += 1
    elif location[i] + height[i] < location[i+1]:
        down += 1
        location[i] = location[i] + height[i]

print(down)

