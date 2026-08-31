def main():
    n = int(input())
    first = [int(x) for x in input().split()]
    second = [int(x) for x in input().split()]
    third = [int(x) for x in input().split()]

    first.sort()
    second.sort()
    third.sort()

    f=False

    for i in range(n-1):
        if first[i]!=second[i]:
            a=first[i]
            f=True
            break

    if f==False:
        a=first[n-1]

    g=False

    for i in range(n-2):
        if second[i]!=third[i]:
            b=second[i]
            g=True
            break

    if g==False:
        b=second[n-2]

    print(a)
    print(b)

main()