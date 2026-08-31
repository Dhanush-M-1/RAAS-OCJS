def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def comb_sort(array):
    n = len(array)
    gap = n - 1
    swaped = False

    while gap >= 1 or swaped:
        if gap < 1:
            gap = 1

        swaped = False
        for i in range(n - gap):
            if array[i] > array[i + gap]:
                swaped = True
                swap(array, i, i + gap)
        gap = int(gap // 1.24)

a = input()
b = []

for el in a:
    if el != "+":
        b.append(el)

comb_sort(b)
print("+".join(b))
