import math

def get_dist(x1, y1, x2, y2, x, y):
	L = (x1 - x2) ** 2 + (y1 - y2) ** 2
	PR = (x - x1) * (x2 - x1) + (y - y1) * (y2 - y1)
	res = True
	cf = PR / L
	if(cf < 0):
		cf = 0
		res = False
	if(cf > 1):
   		cf = 1
   		res = False
	xres = x1 + cf * (x2 - x1)
	yres = y1 + cf * (y2 - y1)
	return xres ** 2 + yres ** 2

n, x, y = map(int, input().split())

min_r2 = 20000000 ** 2
max_r2 = -1
xy = []
i_min = 0
for i in range(n):
    curr_x, curr_y = map(int, input().split())
    curr_x -= x
    curr_y -= y
    xy.append((curr_x, curr_y))
    max_r2 = max(max_r2, curr_x ** 2 + curr_y ** 2)

for i in range(n):
	min_r2 = min(min_r2, get_dist(xy[i - 1][0], xy[i - 1][1], xy[i][0], xy[i][1], 0, 0))

print('%.7f' % ((max_r2 - min_r2) * math.pi))
