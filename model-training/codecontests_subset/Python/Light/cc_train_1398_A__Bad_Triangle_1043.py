def main():
    n = int(input())
    arr = list(map(int, input().split()))
    if arr[0] + arr[1] <= arr[n-1]:
        print("1 2 {}".format(n))
    else:
        print("-1")


for _ in range(int(input())):
    main()
