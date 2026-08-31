n = int(input())
tree = list()
height = list()
num = 1
for i in range(n):
    x,h = [int(x) for x in input().split()]
    tree.append(x)
    height.append(h)
    if i == 0:
        num += 1
    elif i == 1:
        continue
    else:
        if height[i - 1] < tree[i] - tree[i - 1] and height[i - 1] < tree[i - 1] - tree[i - 2]:
            num += 1
        elif height[i - 1] >= tree[i] - tree[i - 1] and height[i - 1] < tree[i - 1] - tree[i - 2]:
            num += 1
        elif height[i - 1] < tree[i] - tree[i - 1] and height[i - 1] >= tree[i - 1] - tree[i - 2]:
            num += 1
            tree[i - 1] += height[i -1]
        else:
            num = num
if n > 1:
    print(num)
else:
    print('1')


    
