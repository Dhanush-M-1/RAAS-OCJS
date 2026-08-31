def minStep(n, count):
    # count = 0
    if(n == 1):
        return count
    if(n % 3 != 0):
        return -1
    else:
        if n % 6 == 0:
            count += 1
            n1 = n//6
            return minStep(n1, count)
        else:
            n2 = n*2
            count += 1
            return minStep(n2, count)


if __name__ == "__main__":
    t = int(input())
    arr = []
    count = 0
    for i in range(t):
        arr.append(int(input()))
    for i in range(t):
        print(minStep(arr[i], count))
