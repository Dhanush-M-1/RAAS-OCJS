# your code goes here





class dsu:

	def __init__ ( self , n ):

		self.p = []

		for x in range(n):

			self.p.append ( x )

	def find(self , v):

		if self.p[v] == v:

			return v

		else :

			self.p[v] = self.find ( self.p[v] )

			return self.p[v]

	def union(self,a,b):

		a = self.find ( a )

		b = self.find ( b )

		if a != b:

			self.p[a] = b

	def __str__ ( self ):

		return str ( self.p )

		





n = int (input() )

DSU = dsu ( n+1 )

WRONG = [] 

for x in range(n-1):

	ss = input().split()

	a = int ( ss[0] )

	b = int ( ss[1] )

	

	if DSU.find(a) == DSU.find(b):

		WRONG.append ( [ a , b ] )

	else:

		DSU.union ( a , b )



z = 2



print ( len ( WRONG ) )

for x in range ( len ( WRONG ) ):

	while ( DSU.find ( 1 ) == DSU.find ( z ) ):

		z+=1

	DSU.union ( 1 , z )

	print ( WRONG[x][0] , WRONG[x][1] , 1 , z )



# Made By Mostafa_Khaled