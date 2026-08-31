from collections import  defaultdict
X = defaultdict(int)
n = int(input())
S = list(input())
for i in S:
   X[i] += 1
if X['8'] == 0 or n < 11:
    print(str(0))
else:
    print(str(min(X['8'],int(n/11))))