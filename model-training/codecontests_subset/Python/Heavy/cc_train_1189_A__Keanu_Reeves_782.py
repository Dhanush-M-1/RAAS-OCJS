from collections import defaultdict
import sys
input = sys.stdin.readline
'''
for CASES in range(int(input())):
n, m = map(int, input().split())
n = int(input())
A = list(map(int, input().split()))
S = input().strip()
sys.stdout.write(" ".join(map(str,ans))+"\n")
'''
inf = 100000000000000000  # 1e17
mod = 998244353


n = int(input())
S = input().strip()
if S.count('1')==S.count('0'):
    print(2)
    print(S[0],S[1:])
else:
    print(1)
    print(S)










































# the end
