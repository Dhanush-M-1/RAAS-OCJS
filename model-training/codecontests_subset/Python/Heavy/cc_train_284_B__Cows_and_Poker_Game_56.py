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
    st = list(str(input.readline().rstrip('\n')))

    dict = {}

    for x in st:
        if x in dict:
            dict[x] += 1
        else:
            dict[x] = 1

    result = 0

    if 'I' in dict:
        if dict['I'] == 1:
            result = 1
        else:
            result = 0
    elif 'A' in dict:
        result = dict['A']
    else:
        result = 0

    output = result
    # -------------------------------OUTPUT----------------------------------
    if os.path.exists('out.txt'):
        open('out.txt', 'w').writelines(str(output))
    else:
        sys.stdout.write(str(output))


if __name__ == '__main__':
    main()
# threading.Thread(target=main).start()
