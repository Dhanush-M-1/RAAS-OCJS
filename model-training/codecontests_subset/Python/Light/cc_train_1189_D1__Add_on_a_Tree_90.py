n = int(input())
node = []
for i in range(1 + n):
	node.append( [] )
for q in range(n - 1):
	k = list(map(int, input().split()))
	node[ k[0] ].append( k[1] )
	node[ k[1] ].append( k[0] )
hobe = True
for i in range(n + 1):
	if(len(node[i]) == 2):
		hobe = False
if hobe :
	print("YES")
else :
	print("NO")