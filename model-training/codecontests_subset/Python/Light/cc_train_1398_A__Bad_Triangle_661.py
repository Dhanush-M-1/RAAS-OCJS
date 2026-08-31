t = int(input())
for i in range(t):
    n = int(input())
    arr = input()
    arr = arr.strip()
    arr = arr.split(' ')
    arr = list(map(int, arr))
    a = arr[0]
    b = arr[1]
    c = arr[n-1]
    if c >= a+b :
        print(1, 2, n)
    else:
        print(-1)
            