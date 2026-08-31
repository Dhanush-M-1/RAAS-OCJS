n = int(input())

nodes = [[] for _ in range(n)]

edges = []
for _ in range(n-1):
    u, v = sorted(map(int, input().split(" ")))
    u -= 1
    v -= 1
    nodes[u].append(v)
    nodes[v].append(u)
    edge = [u, v]
    edges.append(edge)

leaf_nodes = [node for node in nodes if len(node) == 1]
num_ads = [len(node) for node in nodes]

if 2 in num_ads:
    out = "NO"
else:
    out = "YES"
#print(num_ads)
#for u, v in edges:
#    num_ad_u = num_ads[u]
#    num_ad_v = num_ads[v]
#    #if num_ad_u == 1 or num_ad_v == 1:
#    #    continue
#    if num_ad_u == 2 or num_ad_v == 2:
#        out = "NO"
#        break

print(out)