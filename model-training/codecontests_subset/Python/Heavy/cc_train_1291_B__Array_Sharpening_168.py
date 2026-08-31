def solve():
    n = int(input())
    a = list(map(int, input().split()))
    res = 'No'
    ss = 0
    ff = n - 1

    while ss < n and a[ss] >= ss:
        ss += 1
    while ff >= 0 and a[ff] >= n - ff - 1:
        ff -= 1

    ss -= 1
    ff += 1

    if ff <= ss:
       res = 'Yes'

    print(res)


def main():
    t = int(input())
    while t:
        solve()
        t -= 1


main()

'''
1
5
0 1 2 1 0

1
4
0 1 1 1

1
4
1 1 1 1

1
6
2 8 2 8 0 5

1
6
2 8 2 8 6 5

0 1 2 3 4 5 
5 4 3 2 1 0

1 1 1 1 1 1
0 1 0 1 0 1
'''