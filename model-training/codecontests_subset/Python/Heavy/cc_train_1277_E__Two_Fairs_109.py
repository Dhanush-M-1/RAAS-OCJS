for t in range(int(input())):
    n, m, a, b = map(int, input(). split())
    neigh_cities = [[] for i in range(n+1)]
    for i in range(m):
        x, y = map(int, input(). split())
        neigh_cities[x].append(y)
        neigh_cities[y].append(x)
    with_a = 0
    with_b = 0
    remaining_cities = set(range(1, n+1))
    remaining_cities.difference_update({a, b})
    while len(remaining_cities) != 0:
        to_be_explored = set()
        already_explored = set()
        connected_to_a = False
        connected_to_b = False
        comp = []
        to_be_explored.add(remaining_cities.pop())
        while len(to_be_explored) != 0:
            city = to_be_explored.pop()
            comp.append(city)
            already_explored.add(city)
            for i in neigh_cities[city]:
                if i == a:
                    connected_to_a = True
                    continue
                if i == b:
                    connected_to_b = True
                    continue
                if i not in already_explored:
                    to_be_explored.add(i)
                    remaining_cities.discard(i)
        if connected_to_a and not connected_to_b:
            with_a += len(comp)
        if connected_to_b and not connected_to_a:
            with_b += len(comp)
    print(with_a * with_b)
