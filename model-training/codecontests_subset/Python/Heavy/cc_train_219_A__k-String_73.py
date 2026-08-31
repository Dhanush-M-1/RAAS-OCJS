import sys
input = sys.stdin.readline
read_tuple = lambda _type: map(_type, input().split(' '))
from collections import Counter


def solve():
    k = int(input())
    string = dict(Counter(input().replace('\n', '')))
    possible = True
    for val in string.values():
        possible = possible and val % k == 0
    if possible:
        ans = ''
        for ch, count in string.items():
            ans += ch * (count // k)
        ans *= k
        print(ans)
    else:
        print(-1)



if __name__ == '__main__':
    solve()