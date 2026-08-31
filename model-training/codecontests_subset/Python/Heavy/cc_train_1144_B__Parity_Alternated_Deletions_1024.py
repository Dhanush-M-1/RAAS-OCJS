def like_to_delete(lst):
    odd, even = list(), list()
    for elem in lst:
        if elem % 2 == 0:
            even.append(elem)
        if elem % 2 != 0:
            odd.append(elem)
    x, y = len(odd), len(even)
    if x == y:
        return 0
    elif x < y:
        y -= x
        y -= 1
        result = 0
        for i in range(y):
            result += sorted(even)[i]
        return result
    elif x > y:
        x -= y
        x -= 1
        result = 0
        for i in range(x):
            result += sorted(odd)[i]
        return result


n = int(input())
a = [int(j) for j in input().split()]
print(like_to_delete(a))
