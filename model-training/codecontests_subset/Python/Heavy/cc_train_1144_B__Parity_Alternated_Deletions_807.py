import sys


# input = sys.stdin.readline


def main():
    n = int(input())
    a = list(map(int, input().split()))
    chet = []
    nechet = []
    for i in range(n):
        if a[i] % 2 == 0:
            chet.append(a[i])
        else:
            nechet.append(a[i])
    chet.sort()
    nechet.sort()
    if len(chet) == len(nechet):
        return 0
    if len(chet) > len(nechet):
        c = False
        while chet != [] and nechet != []:
            chet.pop()
            c = True
            nechet.pop()
            c = False
        if not c and chet != []:
            chet.pop()
            return sum(chet) if chet != [] else 0
    else:
        c = False
        while chet != [] and nechet != []:
            nechet.pop()
            c = True
            chet.pop()
            c = False
        if not c and nechet != []:
            nechet.pop()
            return sum(nechet) if nechet != [] else 0


if __name__ == "__main__":
    print(main())
