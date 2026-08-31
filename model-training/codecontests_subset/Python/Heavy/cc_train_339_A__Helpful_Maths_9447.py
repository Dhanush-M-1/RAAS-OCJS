def divide(unsorted, low, to):
    if low < to:
        mid = (low + to)//2
        divide(unsorted, low, mid)
        divide(unsorted, mid+1, to)
        merge(unsorted, low, mid, to)
    # return

def merge(unsorted, low ,mid, to):
    leftPointer = low
    rightPointer = mid + 1
    extra = []

    while leftPointer <= mid or rightPointer <= to:
        if leftPointer > mid:
            extra.append(unsorted[rightPointer])
            rightPointer += 1
        elif rightPointer > to:
            extra.append(unsorted[leftPointer])
            leftPointer += 1
        else:
            if unsorted[leftPointer] < unsorted[rightPointer]:
                extra.append(unsorted[leftPointer])
                leftPointer += 1
            else:
                extra.append(unsorted[rightPointer])
                rightPointer += 1

    for i in range(low, to+1):
        unsorted[i] = extra[i-low]

def helpXenia(sum):
    nums = sum.split("+")
    divide(nums, 0, len(nums)-1)

    return "+".join(nums)


if __name__ == '__main__':
    sum = input()
    print(helpXenia(sum))
