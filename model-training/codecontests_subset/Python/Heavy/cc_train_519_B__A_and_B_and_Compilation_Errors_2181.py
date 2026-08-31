# python3
import sys, threading, os.path
import string
import collections, heapq, math, bisect

sys.setrecursionlimit(10 ** 6)
threading.stack_size(2 ** 27)


def main():
    if os.path.exists('in.txt'):
        input = open('in.txt', 'r')
    else:
        input = sys.stdin
    # --------------------------------INPUT---------------------------------
    n = int(input.readline())
    lis1 = list(map(int, input.readline().split()))
    lis2 = list(map(int, input.readline().split()))
    lis3 = list(map(int, input.readline().split()))

    lis1.sort()
    lis2.sort()
    lis3.sort()

    res1, res2 = 0, 0

    for i in range(len(lis2)):
        if lis2[i] == lis1[i] and i+1 == len(lis2):
            res1 = lis1[i+1]
            break
        elif lis2[i] != lis1[i]:
            res1 = lis1[i]
            break

    for i in range(len(lis3)):
        if lis3[i] == lis2[i] and i+1 == len(lis3):
            res2 = lis2[i+1]
            break
        elif lis3[i] != lis2[i]:
            res2 = lis2[i]
            break

    output = str(res1) + "\n" + str(res2)
    # -------------------------------OUTPUT----------------------------------
    if os.path.exists('out.txt'):
        open('out.txt', 'w').writelines(str(output))
    else:
        sys.stdout.write(str(output))


if __name__ == '__main__':
    main()
# threading.Thread(target=main).start()
