__copyright__ = ''
__author__ = 'Son-Huy TRAN'
__email__ = "sonhuytran@gmail.com"
__doc__ = ''
__version__ = '1.0'

from math import ceil

def main() -> int:
    (n, x, y) = map(int, input().split())

    if x / n * 100 >= y:
        print(0)
    else:
        print(ceil(n * y / 100 - x))

    return 0


if __name__ == '__main__':
    exit(main())