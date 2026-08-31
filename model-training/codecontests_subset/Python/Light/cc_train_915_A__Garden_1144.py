def sad(k, lst):
    maximum = 0
    for i in range(len(lst)):
        if k % lst[i] == 0 and lst[i] > maximum:
            maximum = lst[i]
    return k // maximum


N, K = [int(j) for j in input().split()]
b = [int(x) for x in input().split()]
print(sad(K, b))
