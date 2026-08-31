n = int(input())
graph = [_ for _ in range(n)]
reply = []

def findRoot(i):
    return i if i == graph[i] else findRoot(graph[i])

for _ in range(n - 1):
    s = input().split(' ')
    i = int(s[0]) - 1
    j = int(s[1]) - 1

    i_root = findRoot(i)
    j_root = findRoot(j)

    if i_root == j_root:
        reply.append((i,j))
    else:
        graph[i_root] = j_root

print(len(reply))

first_root = (findRoot(0))
for x,y in reply:
    for k in range(1, n + 1):
        k_root = findRoot(k)
        if first_root != k_root:
            graph[k_root] = first_root
            print(x + 1, y + 1, k_root + 1, first_root + 1)
            break
    






