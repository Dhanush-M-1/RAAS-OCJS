def main():
    N, K = map(int, input().split())
    A = (map(int, input().split()))

    a = sorted(A, reverse=True)
    for i in a:
        if not K % i:
            print(K // i)
            break
main()
