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
    n, k = list(map(int, input.readline().split()))
    lis = list(map(int, input.readline().split()))

    interv = []

    x = 1
    for i in range(100002):
        x +=i
        interv.append(x)
    ind = bisect.bisect(interv, k)
    xx = 0
    for i in range(interv[ind-1], interv[ind]):
        if i == k:
            break
        else:
            xx += 1

    output = lis[xx]
    # -------------------------------OUTPUT----------------------------------
    if os.path.exists('out.txt'):
        open('out.txt', 'w').writelines(str(output))
    else:
        sys.stdout.write(str(output))


if __name__ == '__main__':
    main()
# threading.Thread(target=main).start()
