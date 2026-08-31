n = int(input())
maxTree = 2
pos = []
height = []
for trees in range(n):
    x, h = map(int, input().split())
    pos.append(x)
    height.append(h)
if n == 1:
    print(1)
else:
    ocupado = [pos[0]]
    for i in range(1, len(pos) - 1):
        if pos[i] - height[i] > ocupado[-1]:
            maxTree += 1
            ocupado.append(pos[i])
        elif pos[i] + height[i] < pos[i + 1]:
            maxTree += 1
            ocupado.append(pos[i] + height[i])
        else:
            ocupado.append(pos[i])

    print(maxTree)