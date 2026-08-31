CASES = int(input())

for case in range(CASES):
    l1, l2 = [int(x) for x in input().split(" ")]
    seq1 = [int(x) for x in input().split(" ")]
    seq2 = [int(x) for x in input().split(" ")]

    shared_subsequence = []

    for e in seq1:
        if e in seq2:
            shared_subsequence.append(e)
            # I need the minimum
            break


    if len(shared_subsequence):
        print("YES")
        print(len(shared_subsequence), *shared_subsequence, sep=" ")
    else:
        print("NO")

