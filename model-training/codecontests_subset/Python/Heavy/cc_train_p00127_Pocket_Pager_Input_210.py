# -*- coding: utf-8 -*-
"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0127
"""
import sys
input = sys.stdin.readline


def decode(code):
    result = ''
    while code:
        try:
            c = code[:2]
            result += Code_table[c]
            code = code[2:]
        except:
            return 'NA'
    return result


Code_table = {
    '11': 'a', '21': 'f', '31': 'k', '41': 'p', '51': 'u', '61': 'z',
    '12': 'b', '22': 'g', '32': 'l', '42': 'q', '52': 'v', '62': '.',
    '13': 'c', '23': 'h', '33': 'm', '43': 'r', '53': 'w', '63': '?',
    '14': 'd', '24': 'i', '34': 'n', '44': 's', '54': 'x', '64': '!',
    '15': 'e', '25': 'j', '35': 'o', '45': 't', '55': 'y', '65': ' ',
}
def main(args):
    for line in sys.stdin:
        result = decode(line.strip())
        print(result)


if __name__ == '__main__':
    main(sys.argv[1:])