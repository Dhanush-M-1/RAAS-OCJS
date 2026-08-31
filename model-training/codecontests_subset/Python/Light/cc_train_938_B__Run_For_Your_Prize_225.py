import bisect

def main():
    N = int(input())
    A = tuple(map(int, input().split()))

    i = bisect.bisect(A, 500000)
    if not i:
        own = 0
    else:
        own = A[i-1] - 1

    if i == N:
        friend = 0
    else:
        friend = 1000000 - A[i]

    print(max(own, friend))

main()
