def ans(arr):
    l, r, d = arr[0], arr[1], arr[2]
    x1 = l / d
    x2 = r / d
    if(x1 > 1):
        return(d)
    return(d * (int(x2) + 1))
if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = list(map(int, input().strip().split()))
        print(ans(n))