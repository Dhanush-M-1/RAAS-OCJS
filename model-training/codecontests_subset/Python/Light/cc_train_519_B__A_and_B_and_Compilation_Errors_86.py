import collections

if __name__ == "__main__":
    n = int(input())
    a = [int(i) for i in input().split()]
    b = [int(i) for i in input().split()]
    c = [int(i) for i in input().split()]

    countA = collections.Counter(a)
    countB = collections.Counter(b)
    countC = collections.Counter(c)

    for i in countA:
        if i not in countB or countB[i] != countA[i]:
            print(i)
            break
    for i in countB:
        if i not in countC or countB[i] != countC[i]:
            print(i)
            break