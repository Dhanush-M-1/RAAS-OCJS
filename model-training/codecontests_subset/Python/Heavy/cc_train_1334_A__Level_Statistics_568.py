def main():
    test = int(input())

    for t in range(test):
        n = int(input())
        prev = 0
        crev = 0
        ans = ""

        for k in range(0,n):

            l = [int(i) for i in input().split(" ")]
            p = l[0]
            c = l[1]

            if len(ans) == 0:
                if p < c:
                    ans = "NO"
                elif p >= prev and c >= crev and p-prev >= c-crev:
                    prev = p
                    crev = c
                else:
                    ans = "NO"

        if len(ans) == 0:
            print("YES")
        else:
            print("NO")


main()
