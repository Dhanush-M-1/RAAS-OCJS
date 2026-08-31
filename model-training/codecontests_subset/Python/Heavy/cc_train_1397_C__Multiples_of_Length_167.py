import sys

n = int(sys.stdin.readline())
data = [int(d) for d in sys.stdin.readline().strip().split()]

if n > 1:
    print('1 ' + str(n))
    first_iter = []
    for i in range(len(data)):
        first_iter.append(len(data)*(len(data) - 1 - data[i]))
    print(' '.join([str(i) for i in first_iter]))

    for i in range(len(data)):
        data[i] += first_iter[i]

    second_iter = [d*(-1) for d in data[1:]]
    print('2 ' + str(n))
    print(' '.join([str(i) for i in second_iter]))

    print('1 1')
    print(str(data[0]*(-1)))
else:
    print('1 1')
    print(str(data[0]*(-1)))
    print('1 1')
    print('0')
    print('1 1')
    print('0')
