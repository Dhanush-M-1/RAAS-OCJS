def initializeDiffArray(A):
    n = len(A)

    # We use one extra space because
    # update(l, r, x) updates D[r+1]
    D = [0 for i in range(0, n + 1)]

    D[0] = A[0];
    D[n] = 0

    for i in range(1, n):
        D[i] = A[i] - A[i - 1]
    return D


# Does range update
def update(D, l, r, x):
    D[l] += x
    D[r + 1] -= x


# Prints updated Array
def printArray(A, D):
    for i in range(0, len(A)):
        if (i == 0):
            A[i] = D[i]

            # Note that A[0] or D[0] decides
        # values of rest of the elements.
        else:
            A[i] = D[i] + A[i - 1]






for _ in range(int(input())):
    n,m=map(int,input().split())
    s = input()
    a = list(map(int,input().split()))

    freq = [0]*26

    for elem in s:
        freq[ord(elem)-ord('a')]+=1

    A = [0]*n

    # Create and fill difference Array
    D = initializeDiffArray(A)

    for elem in a:
        update(D,0,elem-1,1)

    printArray(A, D)

    for i in range(n):
        freq[ord(s[i])-ord('a')]+=A[i]
    # After below update(l, r, x), the
    # elements should become 20, 15, 20, 40
    print(*freq)
