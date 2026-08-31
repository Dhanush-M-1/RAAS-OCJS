def get_index(lt, vec):
    max_el = 0
    pos = None
    for i in range(len(vec)):
        if i not in lt:
            if max_el < vec[i]:
                max_el = vec[i]
                pos = i
    return pos


n = int(input())
vec = [int(x) for x in input().split()]
lst = [[vec.index(max(vec))]]
for i in range(n-1):
    lt = list(lst[i])
    ind = get_index(lt, vec)
    lt.append(ind)
    lst.append(lt)

for l in lst:
    l.sort()

m = int(input())
for i in range(m):
    k, pos = [int(x) for x in input().split()]
    print(vec[lst[k-1][pos-1]])

