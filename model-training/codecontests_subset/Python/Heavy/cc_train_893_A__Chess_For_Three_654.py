import os
import sys

def log(*args, **kwargs):
    if os.environ.get('CODEFR'):
        print(*args, **kwargs)


n = int(input())
#a = list(map(int,input().split()))
winner = int(input())
loser = 1 if winner == 2 else 2
spec = 3

if winner == spec:
    print('NO')
    sys.exit(0)

for i in range(n-1):
    new_winner = int(input())
    if new_winner == loser:
        print('NO')
        sys.exit(0)

    if new_winner == winner:
        swap = loser
        loser = spec
        spec = swap
    else:
        spec = loser
        loser = winner
    winner = new_winner


print('YES')
    
    
