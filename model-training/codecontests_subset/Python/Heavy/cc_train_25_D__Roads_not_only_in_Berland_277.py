class DSU:
	nodes = []
	duplicates = []

	def __init__(self,n):
		self.nodes = [[0,0] for i in range(n)]

	def find(self,x):
		return self.nodes[x]

	def union(self,x,y):
		xRoot,yRoot = self.find(x),self.find(y)
		if xRoot[0] == yRoot[0]:
			self.duplicates.append([x,y])
			return
		connections = xRoot[1] + yRoot[1]
		xRoot_pointer__original = xRoot[0]
		yRoot_pointer__original = yRoot[0]
		if xRoot[1] > yRoot[1]:
			for node in self.nodes:
				if node[0] == yRoot_pointer__original or node[0] == xRoot_pointer__original:
					node[0] = xRoot_pointer__original
					node[1] = connections
		else:
			for node in self.nodes:
				if node[0] == xRoot_pointer__original or node[0] == yRoot_pointer__original:
					node[0] = yRoot_pointer__original
					node[1] = connections

	def insert(self,x,y):
		if self.nodes[x][0] == 0 and self.nodes[y][0] == 0:
			self.nodes[x] = [x,2]
			self.nodes[y] = [x,2]
		elif self.nodes[x][0] != 0 and self.nodes[y][0] != 0:
			self.union(x,y)
		elif self.nodes[x][0] != 0:
			self.nodes[y] = [y,1]
			self.union(x,y)
		elif self.nodes[y][0] != 0:
			self.nodes[x] = [x,1]
			self.union(x,y)

n = int(input())
dsu = DSU(n+1)
for i in range(n-1):
	a = list(map(int,input().split()))
	x,y = a[0],a[1]
	dsu.insert(x,y)

new_roads = []
connected = -1

for i in range(1,len(dsu.nodes)):
	if dsu.nodes[i] != [0,0]:
		connected = i
		break


for i in range(len(dsu.duplicates)):
	for i in range(1,len(dsu.nodes)):
		if dsu.nodes[i][0] != dsu.nodes[connected][0] and dsu.nodes[i] != [0,0]:
			dsu.union(connected,i)
			new_roads.append([connected,i])
			break

for i in range(1,len(dsu.nodes)):
	if dsu.nodes[i] == [0,0]:
		#dsu.union(connected,i)
		new_roads.append([connected,i])

print(len(new_roads))

for i in range(len(new_roads)):
	print(dsu.duplicates[i][0],dsu.duplicates[i][1],new_roads[i][0],new_roads[i][1])



'''
21
7 15
13 1
14 3
4 10
2 3
16 18
17 20
16 20
8 4
3 12
2 17
13 11
16 1
13 2
13 5
8 9
6 14
3 17
16 9
13 8


10
5 9
8 5
7 6
7 9
3 9
2 1
7 2
3 6
7 1

'''