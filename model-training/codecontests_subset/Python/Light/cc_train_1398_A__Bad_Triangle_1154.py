tests = int(input())

for t in range(tests):
    length = int(input())
    raw = input()
    A = list(map(int, raw.split()))

    if A[length-1] >= (A[0]+A[1]):
        print("1 2", length)
    else:
        print("-1")