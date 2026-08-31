q = int(input())
for i in range(q):
    data = input().split(" ")
    l = int(data[0])
    r = int(data[1])
    d = int(data[2])

    result = d if d < l else r + (d - (r % d))

    print(result)