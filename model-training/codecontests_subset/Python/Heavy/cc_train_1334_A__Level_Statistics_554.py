import sys
input = iter(sys.stdin.readlines()).__next__  # pylint: disable= redefined-builtin
import collections

T = int(input())
for _ in range(T):
    n = int(input())
    Obs = collections.namedtuple("Obs", "p c")
    obs = [Obs(*map(int, input().split())) for _ in range(n)]

    def ok():
        for i in range(n):
            if obs[i].c > obs[i].p: return False

            if i == 0: continue
            plays = obs[i].p - obs[i-1].p
            if plays < 0: return False
            clears = obs[i].c - obs[i-1].c
            if clears < 0 or clears > plays: return False
        else:
            return True

    print("YES" if ok() else "NO")
