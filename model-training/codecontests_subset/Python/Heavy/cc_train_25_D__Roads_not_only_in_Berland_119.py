n = int(input())
parent = list(range(n + 1))


def find(i):
    while i != parent[i]:
        i = parent[i]
    return i


to_delete = []
for _ in range(n - 1):
    a, b = list(map(int, input().split()))
    a_id = find(a)
    b_id = find(b)
    if a_id == b_id:
        to_delete.append((a, b))
    else:
        parent[a_id] = b_id

print(len(to_delete))
first_id = find(1)
for x, y in to_delete:
    for other in range(2, n + 1):
        other_id = find(other)
        if first_id != other_id:
            parent[other_id] = first_id
            print(x, y, other_id, first_id)
            break