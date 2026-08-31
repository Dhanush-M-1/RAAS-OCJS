# Contest No.: 639
# Problem No.: C
# Solver:      JEMINI
# Date:        20200503

import sys

def main():
    t = int(input())
    for _ in range(t):
        n = int(sys.stdin.readline().strip())
        nums = list(map(int, sys.stdin.readline().split()))
        numSet = set()
        flag = True
        for i in range(n):
            if (i + nums[i] % n) % n not in numSet:
                numSet.add((i + nums[i] % n) % n)
            else:
                flag = False
                break
        if max(numSet) - min(numSet) == n - 1 and len(numSet) == n:
            pass
        else:
            flag = False
        
        if flag:
            print("YES")
        else:
            print("NO")
    return

if __name__ == "__main__":
    main()