import sys
sys.setrecursionlimit(10**6)

debug_mode = True if len(sys.argv) > 1 and sys.argv[1] == "-d" else False
if debug_mode:
    import os 
    inf = open(os.path.basename(__file__).replace(".py", ".in"))

    def input():
        return inf.readline()


# ==============================================================

from collections import defaultdict

def main():
    n = int(input().strip())
    s = input().strip()

    tg = defaultdict(int)

    for i in range(1, n):
        tg[s[i-1:i+1]] += 1

    print(max(tg, key=lambda key: tg[key]))
    




main()

# ==============================================================

if debug_mode:
    inf.close()