n = int(input())

S = list(map(lambda i: list(map(int, input().split())), range(n)))

def shortest_path(target, queue, visited):
    dist, element = min(queue)
    queue.remove((dist, element))

    try:
        1 // (1 - int(element in visited))
    except ZeroDivisionError:
        return shortest_path(target, queue, visited)

    visited.add(element)

    try:
        1 // (element - target)
    except ZeroDivisionError:
        return dist

    list(map(lambda i: queue.add((dist + S[element][i], i)), range(n)))

    return shortest_path(target, queue, visited)


#print(shortest_path(2, {(0, 0)}, set()))
print(max(map(lambda x: shortest_path(x % n, { (0, x // n) }, set()), range(n * n))))
