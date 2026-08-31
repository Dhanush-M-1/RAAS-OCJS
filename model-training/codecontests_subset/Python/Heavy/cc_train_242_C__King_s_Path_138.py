from sys import stdin, stdout 
import time,math
from collections import defaultdict
#n,m=map(int,input().split()) 
# for i in range(n):
#     t=int(stdin.readline()) # input using fast i/p method 
#     if t%m == 0:
#         stdout.write(str(t)+'\n') #input using fast o/p method

# take line of integers as input
# 	arr = list(map(int, inp().split()))

##########################################################################################
def pn(ob):stdout.write(str(ob))

def inp():return stdin.readline()

def fpow(n,p):
	if(p==1):
		return n
	if((p&1)==1):
		return n*fpow(n,p-1)
	else:
		return fpow(n,p/2)*fpow(n,p/2)
###########################################################################################

def def_val():
	return False
def def_dist():
	return math.inf

valid=defaultdict(def_val)
dist=defaultdict(def_dist)

dx = (-1, 0, 1, 0, 1, 1, -1, -1);
dy = (0, 1, 0, -1, 1, -1, 1, -1);

def bfs(x,y,dest):
	q=[]
	q.append((x,y))
	valid[(x,y)]=False
	dist[(x,y)]=0

	while(len(q)>0):
		coords=q.pop(0)

		for k in range(0,8,1):
			x=coords[0]+dx[k]
			y=coords[1]+dy[k]

			new_coords=(x,y)
			dist[new_coords]=min(dist[coords]+1,dist[new_coords])

			if(valid[new_coords]):
				valid[new_coords]=False
				q.append(new_coords)

	if(dist[dest]==math.inf):
		pn(-1)
	else:
		pn(dist[dest])
	


def process():
	#code here
	x0,y0,x1,y1=map(int,input().split())
	n=int(inp())

	for i in range(0,n,1):
		r,a,b=map(int,input().split())
		for j in range(a,b+1,1):
			valid[(r,j)]=True

	bfs(x0,y0,(x1,y1))


def main():
	t=1
	#t=int(inp())
	# start = time.time()

	# while (t>0):
	# 	t-=1
	# 	process()
	# end = time.time()
	# print('\nelapsed time',end - start)
	process()
  
if __name__ == '__main__':
	main()
	
	
	