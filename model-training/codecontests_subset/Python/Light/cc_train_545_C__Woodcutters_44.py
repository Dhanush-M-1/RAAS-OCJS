n = int(input())
px, ph, pd = -1, -1, -1
r = 0
for i in range(n):
    x, h = map(int, input().split())
    if i == 0:
        px, ph, pd = x, h, -1
    else:
        if px + ph * pd >= x:
            pd = 0
        if pd != 0:
            r += 1
        if max(px + ph * pd, px) < x - h:
            pd = -1
        else:
            pd = 1
        px, ph = x, h
print(r + 1)
