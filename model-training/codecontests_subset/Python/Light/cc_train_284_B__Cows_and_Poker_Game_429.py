from collections import Counter


def main():
    input()
    cnt = Counter(input())
    if not cnt['I']:
        print(cnt['A'])
    elif cnt['I'] == 1:
        print('1')
    else:
        print('0')


if __name__ == '__main__':
    main()