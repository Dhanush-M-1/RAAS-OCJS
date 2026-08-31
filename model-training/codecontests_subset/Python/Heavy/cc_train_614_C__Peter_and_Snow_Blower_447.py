import math

n, a, b = [int(x) for x in input().split()]
distances = []
x, y = [int(x) for x in input().split()]
distances.append(math.hypot(x - a, y - b))
prevx, prevy = x, y
firstx, firsty = x, y
for i in range(n-1):
    x, y = [int(x) for x in input().split()]
    distances.append(math.hypot(x - a, y - b))
    scalar_mult = (a-x)*(prevx-x) + (b-y)*(prevy-y)
    sq = (prevx - x)**2 + (prevy - y)**2
    if 0 < scalar_mult < sq:
        distances.append(((a-x)**2 + (b-y)**2 - scalar_mult**2/sq) ** 0.5)
    prevx, prevy = x, y
scalar_mult = (a-prevx)*(firstx-prevx) + (b-prevy)*(firsty-prevy)
sq = (firstx - prevx)**2 + (firsty - prevy)**2
if 0 < scalar_mult < sq:
    distances.append(((a-prevx)**2 + (b-prevy)**2 - scalar_mult**2/sq) ** 0.5)

distances.sort()
print((distances[-1] - distances[0])*(distances[-1] + distances[0])*math.pi)
