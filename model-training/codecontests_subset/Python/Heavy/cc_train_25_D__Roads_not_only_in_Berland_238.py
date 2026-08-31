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

idx = 0

for i in range(n):
    if find_set(i) == i:
        for j in range(n):
            if i != j and find_set(j) == j:
                P.append( (edges[idx][0]+1, edges[idx][1]+1, i+1, j+1) )
                idx += 1
                union_set( i, j )
                break

print( len(P ) )

for i, j, k, z in P:
    print( i, j, k, z )
