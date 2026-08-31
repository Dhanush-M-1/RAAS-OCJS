def main():
    def solve():

        n = int(input())
        aa = [int(a) for a in input().split()]
        for i,a in enumerate(aa):
            if a < i:
                break
        else:
            i = n
        for j,a in enumerate(aa[::-1]):
            if a < j:
                break
        else:
            j = n
        if i+j <= n:
            print("No")
        else:
            print("Yes")


    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()