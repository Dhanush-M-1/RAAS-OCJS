#https://codeforces.com/problemset/problem/219/A

import sys
import math

def main():
    # sys.stdin = open('E:\\Sublime\\in.txt', 'r')
    # sys.stdout = open('E:\\Sublime\\out.txt', 'w')
    # sys.stderr = open('E:\\Sublime\\err.txt', 'w')
    
    n = int(sys.stdin.readline().strip())
    # a, b = map(int, sys.stdin.readline().strip().split()[:2])
    s = sys.stdin.readline().strip()
    s1 = list(set(list(s)))
    p = []

    for c in s1:
        x = s.count(c)
        if x % n != 0:
            print(-1)
            exit()
        p.append(x // n)

    res = ''

    for i in range(len(s1)):
        res += (p[i] * s1[i])
    
    print(res * n)

if __name__ == '__main__':
    main()

#hajj
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