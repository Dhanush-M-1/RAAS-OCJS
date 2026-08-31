def missing_element(array1, array2):
    i, j = 0, 0
    el = 0

    while i < len(array1) and j < len(array2):
        if array1[i] != array2[j]:
            if array1[i+1] == array2[j]:
                el = array1[i]
            else:
                el = array2[j]
            break
        else:
            i += 1
            j += 1

    if el == 0:
        return array1[-1]
    else:
        return el


n = int(input())
array = sorted(list(map(int, input().split())))
arr1 = sorted(list(map(int, input().split())))
arr2 = sorted(list(map(int, input().split())))

print(missing_element(array, arr1))
print(missing_element(arr1, arr2))