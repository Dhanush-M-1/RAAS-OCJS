def get_dic(a):
    d = dict()
    for e in a:
        if e in d.keys():
            d[e] += 1
        else:
            d[e] = 1
    return d

n = int(input())

d1 = get_dic(map(int, input().split()))
d2 = get_dic(map(int, input().split()))
d3 = get_dic(map(int, input().split()))

for e in d1.keys():
    if e not in d2.keys():
        print(e)
        break
    else:
        if d1[e] != d2[e]:
            print(e)
            break

for e in d2.keys():
    if e not in d3.keys():
        print(e)
        break
    else:
        if d2[e] != d3[e]:
            print(e)
            break
