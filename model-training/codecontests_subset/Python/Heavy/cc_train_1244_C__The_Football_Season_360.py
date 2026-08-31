#Bhargey Mehta (Junior)
#DA-IICT, Gandhinagar
import sys, math, queue, collections
#sys.stdin = open('input.txt', 'r')
MOD = 10**9+7
sys.setrecursionlimit(1000000)

n, p, w, d = map(int, input().split())

for wins in range(d):
    if (p-wins*w) % d == 0:
        draws = (p-wins*w) // d
        loses = n - wins - draws
        if wins >= 0 and draws >= 0 and loses >= 0:
            print(wins, draws, loses)
            exit()
for draws in range(w):
    if (p-draws*d) % w == 0:
        wins = (p-draws*d) // w
        loses = n - wins - draws
        if wins >= 0 and draws >= 0 and loses >= 0:
            print(wins, draws, loses)
            exit()
print(-1)