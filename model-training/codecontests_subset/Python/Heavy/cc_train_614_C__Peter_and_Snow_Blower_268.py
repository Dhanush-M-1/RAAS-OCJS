import math
n, px, py = map(int, input().split())

def line_mindist(x1, y1, x2, y2):
	cos1 = ((px - x1) * (x2 - x1) + (py - y1) * (y2 - y1)) 
	cos2 = ((px - x2) * (x1 - x2) + (py - y2) * (y1 - y2))
	if cos1 < 0 or cos2 < 0:
		dist1 = (px - x1)**2 + (py - y1)**2 
		dist2 = (px - x2)**2 + (py - y2)**2
		return min(dist1, dist2)
	if x2 == x1:
		perp_dist =  abs(px - x1)**2
	elif y2 == y1:
		perp_dist =  abs(py - y1)**2
	else:
		m = (y1 - y2) / (x1 - x2)
		c = y1 - m * x1
		perp_dist = abs(py - m * px - c)**2 / (1 + m * m)
	
	return perp_dist

pi = 3.14159265358979323846264338327950288419717

maxdist = 0
mindist = 1000000000000000000
past_x, past_y = map(int, input().split())
first_x = past_x
first_y = past_y
for i in range(1, n):
	d = (past_x - px) * (past_x - px) + (past_y - py) * (past_y - py)
	if d > maxdist:
		maxdist = d
	
	x, y = map(int, input().split())
	d = line_mindist(past_x, past_y, x , y)
	if d < mindist:
		mindist = d
	past_x = x
	past_y = y

d = (past_x - px) * (past_x - px) + (past_y - py) * (past_y - py)
if d > maxdist:
	maxdist = d

d = line_mindist(past_x, past_y, first_x , first_y)
if d < mindist:
	mindist = d

#print(mindist)
#print(maxdist)
print(pi * (maxdist - mindist) )
