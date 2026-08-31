t = int(input())

from collections import defaultdict

def bfs(graph, x, forb):
    visited = set()
    circle = [x]
    while len(circle) > 0:
        new = set()
        for v in circle:
            if v in visited:
                continue
            visited.add(v)
            for pov in graph[v]:
                if pov not in forb:
                    new.add(pov)
        circle = new
    return visited

def can_visit(graph, x):
    visited = set()
    circle = [x]
    while len(circle) > 0:
        new = set()
        for v in circle:
            if v in visited:
                continue
            visited.add(v)
            for pov in graph[v]:
                new.add(pov)
        circle = new
    return visited

for _ in range(t):
    n, m, a, b = list(map(int, input().strip().split()))

    graph = defaultdict(list)

    for _ in range(m):
        x, y = list(map(int, input().strip().split()))
        graph[x].append(y)
        graph[y].append(x)

    start = 0
    for i in range(1, n+1):
        if i != a and i != b:
            start = i
            break
    
    iza = bfs(graph, a, [b])
    izb = bfs(graph, b, [a])

    intersection = iza & izb

    # print(iza)
    # print(izb)
    # print(intersection)

    num1 = len(iza) - 1 - len(intersection)
    num2 = len(izb) - 1 - len(intersection)

    print(num1*num2)


    # print(start)
    # prvi = bfs(graph, start, set([a,b]), n)
    # print(prvi)
    # drugi = bfs(graph, start, set([a]), n)
    # print(drugi)
    # tretji = bfs(graph, start, set([b]), n)
    # print(tretji)

    # p1, p2, p3 = len(prvi), len(drugi), len(tretji)
    # g1 = (n - 2 - p1) * p1
    # g2 = (n - 1 - p2) * p2
    # g3 = (n - 1 - p3) * p3
    # print(g1, g2, g3)
    # print(g1 - g2 - g3)
    # print('END CASE')
    

