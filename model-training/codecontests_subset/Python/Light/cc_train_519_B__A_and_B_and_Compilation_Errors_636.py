n = int(input())


def count(arr):
    out = {}
    for el in arr:
        out[el] = out.get(el, 0) + 1
    return out


first = count(map(int, input().split()))
sec = count(map(int, input().split()))
third = count(map(int, input().split()))

for el in first:
    if first[el] > sec.get(el, 0):
        print(el)
        break

for el in sec:
    if sec[el] > third.get(el, 0):
        print(el)
        break
