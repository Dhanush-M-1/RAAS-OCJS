# 1:37
n_queries = int(input())
queries = [[int(i) for i in input().split()] for x in range(n_queries)]


def parse(query):
    l, r, d = query
    if d < l:
        return d
    return ((r // d) + 1) * d


for query in queries:
    print(parse(query))
