n = int( input() )

p = [0]*n
rank = [0]*n

for i in range( n ):
    p[i] = i

def find_set( x ):

    if x == p[x]:
        return ( x )

    return ( find_set( p[x] ) )

def union_set( a, b ):

    fa = find_set( a )
    fb = find_set( b )

    if rank[fa] < rank[fb]:
        p[fa] = fb
    else:
        p[fb] = fa

    if rank[a] == rank[b]:
        rank[a] += 1

edges = []

for i in range( n-1 ):
    a, b = list( map( int, input().split() ) )

    fa = find_set(a-1)
    fb = find_set(b-1)

    if fa == fb:
        edges.append( (a-1,b-1,fa) )
    else:
        union_set( a-1, b-1 )

#print( edges )

used = [False] * len(edges)
P = []

q = []

for i in range(n):
    if find_set(i) == i:
        q.append(i)

for i in range( len(q)-1 ):
    P.append( (edges[i][0]+1, edges[i][1]+1, q[i]+1, q[i+1]+1) )
    union_set( q[i], q[i+1] )

print( len(P ) )

for i, j, k, z in P:
    print( i, j, k, z )
