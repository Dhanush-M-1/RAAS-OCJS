def main():
    test=int(input())
    for _ in range(test):
        l=int(input())
        arr=list(map(int,input().split()))
        sum=arr[0]+arr[1]
        if arr[-1]>=sum:
            print(1,2,l)
        else:
            print(-1)
            




main()