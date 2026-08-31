__copyright__ = ''
__author__ = 'Son-Huy TRAN'
__email__ = "sonhuytran@gmail.com"
__doc__ = ''
__version__ = '1.0'


def find_k_string(string: str, k: int) -> str:
    char_dict = {}

    for char in string:
        char_dict[char] = char_dict.get(char, 0) + 1

    for key in char_dict.keys():
        if char_dict[key] % k != 0:
            return '-1'

    result = []

    for key in char_dict.keys():
        count = char_dict[key] // k
        result += [key] * count

    result = result * k
    return ''.join(result)


def main() -> int:
    k = int(input())
    string = input()

    print(find_k_string(string, k))
    return 0


if __name__ == '__main__':
    exit(main())