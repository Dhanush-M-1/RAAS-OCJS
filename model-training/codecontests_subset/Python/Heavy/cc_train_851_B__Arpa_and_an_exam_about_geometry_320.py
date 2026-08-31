import sys
import math

ax, ay, bx, by, cx, cy = [int(x) for x in sys.stdin.readline().strip().split(" ")]

def dist(ax, ay, bx, by):
  return (bx - ax) ** 2 + (by - ay) ** 2

def slope(ax, ay, bx, by):
  if(bx - ax == 0):
    return float("inf")
  return ((by - ay + 0.0) / (bx - ax))
  
def collinear(ax, ay, bx, by, cx, cy):
  if(slope(ax, ay, bx, by) == slope(bx, by, cx, cy)):
    return True
  else:
    return False
  
if(dist(ax, ay, bx, by) == dist(bx, by, cx, cy) and not collinear(ax, ay, bx, by, cx, cy)):
  print("yes")
else:
  print("no")
	 			 		  			  	 			  	 	 	  	