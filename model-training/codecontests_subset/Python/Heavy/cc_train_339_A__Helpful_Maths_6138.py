def main():
    def partition(arr, low, high):
        i = (low-1)         # index of smaller element
        pivot = int(arr[high])     # pivot
        for j in range(low, high):
            if int(arr[j]) < pivot:
                i = i+1
                arr[i], arr[j] = int(arr[j]), int(arr[i])
        arr[i+1], arr[high] = int(arr[high]), int(arr[i+1])
        return (i+1)

    def quickSort(arr, low, high):
        if low < high:
            pi = partition(arr, low, high)
            quickSort(arr, low, pi-1)
            quickSort(arr, pi+1, high)

    s = input()
    if len(s) <= 100:
        arr = s.split('+')
        quickSort(arr, 0, len(arr)-1)
        newS = '+'.join([str(elem) for elem in arr])
        print(newS)
    else:
        pass


if __name__ == '__main__':
    main()
