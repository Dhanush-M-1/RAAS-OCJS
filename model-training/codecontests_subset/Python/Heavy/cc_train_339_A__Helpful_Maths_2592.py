# https://codeforces.com/problemset/problem/339/A
import sys
#-----------------------------------------------------------------------------#
try:
    sys.stdin = open('inputs.txt', 'r')
    sys.stdout = open('output.txt', 'w')
except:
    pass
finally:
    input = sys.stdin.readline
    print = sys.stdout.write

#-----------------------------------------------------------------------------#

q = list(map(int, input().split('+')))

count = [0] * 3

for num in q:
    count[num - 1] += 1

new_q = [str(i + 1) for i, j in enumerate(count) for _ in range(j)]

print("+".join(new_q))
