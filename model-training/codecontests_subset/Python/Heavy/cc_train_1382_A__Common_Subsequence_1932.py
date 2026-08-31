if __name__ == "__main__":
    T = int(input())
    for t in range(T):
        N, M = list(map(int, input().split()))
        A = list(map(int, input().split()))
        B = list(map(int, input().split()))
        found = False
        ans = 0
        for a in A:
            for b in B:
                if a == b:
                    found = True
                    ans = a
                    break
            if found:
                break
        if found:
            print("YES")
            print("1 ", ans)
        else:
            print("NO")

