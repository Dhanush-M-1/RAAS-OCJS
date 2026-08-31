def subArray(source, arr, dept):
    res = []
    res1 = []
    res2 = []
    if len(arr) == 1:
        return [dept]
    index = arr.index(max(arr))
    arr1 = arr[0:index]
    arr2 = arr[index + 1:len(arr)]
    arr[index] = dept
    while True:
        if len(arr1) > 0:
            res1 = subArray(source, arr1,dept+1)
        if len(arr2) > 0:
            res2 = subArray(source, arr2, dept+1)
            break
        else:
            break
    res = res1 + [dept] + res2
    return res

if __name__ == '__main__':
    n = int(input())
    for i in range(0,n):
        m = int(input())
        arr = [ int(x) for x in input().split()]
        print(str(subArray(arr,arr , 0))[1:-1].replace(', ', ' '))
