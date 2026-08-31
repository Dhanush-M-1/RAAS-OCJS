#! /usr/bin/env python3
# -*- coding: UTF-8 -*-


def check(line):
    lst = sorted(line)
    last = -1
    for item in lst:
        if last != -1 and ord(item) != last + 1:
            return False
        last = ord(item)
    return True


def main():
    n_row = input()
    line = input()
    num = line.split(' ')
    odd, even = [], []
    for i in num:
        item = int(i)
        if item % 2:
            odd.append(item)
        else:
            even.append(item)
    odd = sorted(odd, reverse=True)
    even = sorted(even, reverse=True)
    if abs(len(odd)-len(even)) <= 1:
        print(0)
        return
    min_size = min(len(odd), len(even))
    sum = 0
    for i in range(min_size+1, len(odd)):
        sum += odd[i]
    for i in range(min_size+1, len(even)):
        sum += even[i]
    print(sum)


if __name__ == '__main__':
    main()
