# https://codeforces.com/contest/774/problem/K

import sys
import math

vowel = 'aeiouy'
oe = 'oe'


def main():
    # sys.stdin = open('E:\\Sublime\\in.txt', 'r')
    # sys.stdout = open('E:\\Sublime\\out.txt', 'w')
    # sys.stderr = open('E:\\Sublime\\err.txt', 'w')

    n = int(sys.stdin.readline().strip())
    s = sys.stdin.readline().strip()
    # a, b = map(int, sys.stdin.readline().strip().split()[:2])

    s += '#'
    res = []
    i = 0

    while True:
        if i >= n:
            break
        
        res.append(s[i])
        if s[i] in vowel:
            if s[i] in oe and s[i+1] == s[i] and s[i+2] != s[i]:
                res.append(s[i])
                i += 2
            else:
                j = i
                while s[i] == s[j]:
                    i += 1
        else:
            i += 1

    print(''.join(res))


if __name__ == '__main__':
    main()

# hajj
#  　　　　　　 ＿＿
# 　　　　　／＞　　フ
# 　　　　　| 　_　 _ l
# 　 　　　／` ミ＿xノ
# 　　 　 /　　　 　 |
# 　　　 /　 ヽ　　 ﾉ
# 　 　 │　　|　|　|
# 　／￣|　　 |　|　|
# 　| (￣ヽ＿_ヽ_)__)
# 　＼二つ
