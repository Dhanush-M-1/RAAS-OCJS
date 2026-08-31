def main():
    n,s = map(int,input().split())
    array = list(map(int,input().split()))

    array.sort()
    mid = array[n//2]
    ans = 0
    #print(array,mid)
    if mid == s:
        print (0)
        return
    if mid < s:
        ans = 0
        for i in range(n//2,n):
            if s > array[i]:
                ans += s-array[i]
            else:
                break
    else:
        for i in range(n//2,-1,-1):
            if s < array[i]:
                ans += array[i]-s
            else:
                break

    print(ans)

main()
