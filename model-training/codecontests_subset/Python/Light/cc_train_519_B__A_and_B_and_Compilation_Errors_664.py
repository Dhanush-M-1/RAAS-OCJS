def Main():
    n = int(input())
    err1 = list(map(int, input().split()))
    err2 = list(map(int, input().split()))
    err3 = list(map(int, input().split()))

    err1.sort()
    err2.sort()
    err3.sort()

    j = 0
    for i in range(n):
        if j>=n-1 or err1[i] != err2[j]:
            print(err1[i])
            break
        else:
            j+=1

    j = 0
    for i in range(n-1):
        if j>=n-2 or err2[i] != err3[j]:
            print(err2[i])
            break
        else:
            j+=1


if __name__ == "__main__":
    Main()
