def check(arr,n):
    index = -1
    for i in range(1,n):
        if arr[i] < arr[i-1]:
            index = i
            break
        elif arr[i] == arr[i-1]:
            return False

    for i in range(index,n-1):
        if arr[i+1] >= arr[i]:
            return False

    return True

def possible(arr,n):
    index = -1
    for i in range(n):
        if arr[i] >= i:
            arr[i] = i
        else:
            index = i
            break
    
    if index == -1:
        return True

    #print(index,arr)
    val = 0
    for i in range(n-1,index-1,-1):
        if arr[i] >= val:
            arr[i] = val
            val += 1
        else:
            break

    #print(arr)
    if check(arr,n):
        return True
    else:
        return False

def solve(arr,n,ans):
    arr1 = arr[:]
    arr.reverse()
    if possible(arr1,n) or possible(arr,n):
        ans.append('Yes')
        return
    ans.append('No')
    

def main():
    ans = []
    t = int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int,input().split()))
        solve(arr,n,ans)

    for i in ans:
        print(i)


main()
