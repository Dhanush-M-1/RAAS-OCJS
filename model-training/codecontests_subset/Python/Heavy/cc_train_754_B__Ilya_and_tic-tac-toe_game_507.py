import sys


def finder(arr):
    if any(map(lambda x: x.find('.xx') > -1 or
               x.find('xx.') > -1 or
               x.find('x.x') > -1, arr)):
        print('YES')
        sys.exit()

field = [input() for _ in range(4)]
finder(field)

transposed = list(map(lambda x: ''.join(x), zip(*field[::-1])))
finder(transposed)

def diags(arr):
    for y_of in range(2):
        for x_of in range(2):
            yield ''.join([arr[y_of + i][x_of + i] for i in range(3)])
            yield ''.join([arr[3-(y_of + i)][x_of + i] for i in range(3)])
finder(list(diags(field)))

print('NO')
