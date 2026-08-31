q = int(input())
queries_list = []

for i in range(1,q+1):
    queries_list.append(input().split())

for query in queries_list:

    x = int(query[2])
    d = int(query[2])
    r = int(query[1])
    l = int(query[0])

    if d < l or d > r:
        print(d)
    else:
        print(int(int(r/d+1)*d))