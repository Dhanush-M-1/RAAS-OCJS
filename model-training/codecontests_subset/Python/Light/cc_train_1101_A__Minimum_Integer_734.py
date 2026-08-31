record = []
query = int(input())
for i in range(query):
    record.append(input())


for values in record:
    li, ri, di = map(int, values.split())
    contain = None

    if di < li or di > ri:
        contain = di
    else:
        multiplier = ri // di + 1
        contain = di * multiplier

    print(contain)

