import math

def distance_square(ax, ay, bx, by):
	return (ax - bx)**2 + (ay - by)**2

def right_triangle(ax, ay, bx, by, cx, cy):
	# print(distance_square(ax, ay, cx, cy))
	# print(distance_square(ax, ay, bx, by) + distance_square(bx, by, cx, cy))
	return distance_square(ax, ay, cx, cy) == distance_square(ax, ay, bx, by) + distance_square(bx, by, cx, cy)

def triangle_area(ax, ay, bx, by, cx, cy):
	return ax * (by - cy) + bx * (cy - ay) + cx * (ay - by) != 0

coord = [int(i) for i in input().split(" ")]

ax, ay, bx, by, cx, cy = coord

if distance_square(ax, ay, bx, by) == distance_square(bx, by, cx, cy) and triangle_area(ax, ay, bx, by, cx, cy) != 0:
	print("Yes")

# Right triangle
elif distance_square(ax, ay, bx, by) == distance_square(bx, by, cx, cy) and right_triangle(ax, ay, bx, by, cx, cy):
	print("Yes")

# equilateral triangle
elif distance_square(ax, ay, bx, by) == distance_square(bx, by, cx, cy) and distance_square(bx, by, cx, cy) == distance_square(cx, cy, ax, ay) and triangle_area(ax, ay, bx, by, cx, cy) != 0:
	print("Yes")

else:
	print("No")
	  		   	 	       	 		  	 		  	