def findTriangle(arr,n):
    if n < 3:
        return -1
    i = 0
    j = 1
    k = 2
    while k < n-1:
        if (arr[i]+arr[j] <= arr[k]) or (arr[j]+arr[k] <= arr[i]) or (arr[i]+arr[k] <= arr[j]):
            return str(i+1)+" "+str(j+1)+" "+str(k+1)
        k+=1
    while j<n-2:
        if (arr[i]+arr[j] <= arr[k]) or (arr[j]+arr[k] <= arr[i]) or (arr[i]+arr[k] <= arr[j]):
            return str(i+1)+" "+str(j+1)+" "+str(k+1)
        j+=1
    while i<n-2:
        if (arr[i]+arr[j] <= arr[k]) or (arr[j]+arr[k] <= arr[i]) or (arr[i]+arr[k] <= arr[j]):
            return str(i+1)+" "+str(j+1)+" "+str(k+1)
        i+=1
    return -1


t = int(input())
main_arr = []
n_s = []
for a in range(0,t):
    n = int(input())
    n_s.append(n)
    arr = input().rstrip().split(" ")
    for b in range(0,n):
        arr[b] = int(arr[b])
    main_arr.append(arr)
for c in range(0,t):
    print(findTriangle(main_arr[c],n_s[c]))