n = int(input())
sequence = list(map(int, input().split()))
array = list(sequence)
array.sort(reverse=True)
m = int(input())
for i in range(m):
    k, pos = map(int, input().split())
    D = dict()
    for elem in array[:k]:
        if elem in D:
            D[elem] += 1
        else:
            D[elem] = 1
    for elem in sequence:
        if elem in D and D[elem] != 0:
            D[elem] -= 1
            if pos == 1:
                print(elem)
                break
            else:
                pos -= 1
