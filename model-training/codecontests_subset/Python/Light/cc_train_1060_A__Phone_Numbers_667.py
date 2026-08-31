def main():
    n = int(input())
    s = input()
    count8 = s.count('8')
    res = n // 11
    if (res == count8):
        print(res, end = ' ')
    elif (res < count8):
        print(res, end = ' ')
    elif (res > count8):
        print(count8, end = ' ')

if __name__ == '__main__':
    main()