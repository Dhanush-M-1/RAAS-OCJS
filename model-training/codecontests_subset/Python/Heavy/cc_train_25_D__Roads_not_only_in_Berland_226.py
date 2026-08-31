def find_set(v):
    if (v == parent[v]):
        return v
    parent[v] = find_set(parent[v])
    return parent[v]


def union_sets(a,b):
    a=find_set(a)
    b=find_set(b)
    if (a!=b):
        if (size[a]<size[b]):
            a,b = b,a
        parent[b] = a
        size[a] += size[b]
        return True
    return False


n = int(input())
parent = [0]*n
size = [1]*n

mustBreak=[]
mustConnect=[]
for i in range(n):
    parent[i] = i

for i in range(n-1):
    line=input().split(" ")
    a = int(line[0])-1
    b = int(line[1])-1
    result= union_sets(a,b)
    if not result:
        mustBreak.append((a,b))

for i in range(n):
    if parent[i] == i:
        mustConnect.append(i)

lenMustBreak = len(mustBreak)
print(lenMustBreak)
if (lenMustBreak != 0):
    for i in range(lenMustBreak):
        print(str(mustBreak[i][0]+1)+" "+str(mustBreak[i][1]+1)+" "+str(mustConnect[i]+1)+" "+str(mustConnect[i+1]+1))
    