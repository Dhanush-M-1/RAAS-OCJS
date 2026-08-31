def main():
    n = int(input())
    s = [int(x) for x in input().split()]
    sum = 0
    sum1 = 0
    sum2 = 0
    for i in range(n):
        sum += s[i]
    arr1 = []
    arr2 = []
    for i in range(n):
        if s[i] % 2 == 0:
            arr2.append(s[i])
        else:
            arr1.append(s[i])
    arr1.sort()
    arr2.sort()
    arr1 = arr1[::-1]
    arr2 = arr2[::-1]
    if abs(len(arr1) - len(arr2)) <= 1:
        ans = 0
    elif len(arr1) == 0 or len(arr2) == 0:
        ans = sum - max(s)
    elif len(arr1) > len(arr2):
        for i in range(len(arr2)):
            sum1 += arr1[i]
            sum2 += arr2[i]
        ans = sum - sum1 - sum2
        ans -= arr1[len(arr2)]
    else:
        for i in range(len(arr1)):
            sum1 += arr1[i]
            sum2 += arr2[i]
        ans = sum - sum1 - sum2
        ans -= arr2[len(arr1)]
    print(ans)





main()
