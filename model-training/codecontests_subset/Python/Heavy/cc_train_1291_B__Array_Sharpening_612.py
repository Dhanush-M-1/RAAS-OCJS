'''input
11
3
0 1 1
1
248618
3
12 10 8
6
100 11 15 9 7 8
4
0 1 1 0
2
0 0
2
0 1
2
1 0
2
1 1
3
0 1 0
3
1 0 1
'''
import sys
read = lambda: list(map(int,sys.stdin.readline().strip().split()))
for _ in range(int(input())):
    n = int(input())
    l = read()
    n1 = n-1
    dec = False
    temp = -1
    left = 0
    while left<n and left<=l[left]:
        left += 1
    temp = -1
    right = 0
    while right<n and right<=l[n1-right]:
        right += 1
    # print(left,right,end=' ')
    if left+right>=n and (left==n or (n1-left)<l[left-1]):
        print('Yes')
    else:
        print('No')
    