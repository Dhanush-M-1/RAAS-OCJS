# coding=utf-8

if __name__ == '__main__':
    a, b = str(input()).split(' ')
    a = int(a)
    b = int(b)
    miss = 0
    value = a
    while True:
        a += miss
        if a < b:
            break
        miss = a - int(a / b) * b
        a = int(a / b)
        value += a
    print(value)
