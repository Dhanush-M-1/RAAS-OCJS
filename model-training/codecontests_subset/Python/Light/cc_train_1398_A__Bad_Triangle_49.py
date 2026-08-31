def A():
    n = int(input())
    arr = list(map(int, input().split()))
    x = arr[0] + arr[1]
    ans = []
    if arr[-1] >= x:
        ans.append(1)
        ans.append(2)
        ans.append(n)
        return ans
    return ans


if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        ans = A()
        if not ans:
            print("-1")
        else:
            for i in range(3):
                print(ans[i], end = " ")
            print("")