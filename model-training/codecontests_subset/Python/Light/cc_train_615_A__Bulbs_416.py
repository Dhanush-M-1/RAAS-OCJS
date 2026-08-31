#from functools import cmp_to_key
#from collections import deque
import math
def main():
    n,m = map(int,input().split())
    s = set()
    for i in range(n):
        l = [int(j) for j in input().split()][1:]
        for j in l:
            s.add(j)
    if len(s) == m:
        print("YES")
    else:
        print("NO")



if __name__ == "__main__":
    main()