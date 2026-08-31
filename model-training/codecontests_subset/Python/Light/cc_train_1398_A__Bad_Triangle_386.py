def main():
    for i in range(int(input())):
        n = int(input())
        arr = list(map(int,input().split()))
        if arr[n-1]>=arr[0]+arr[1]:
            print('1 2 {}'.format(n))
        else:
            print(-1)
if __name__ == "__main__":
    main()