#!/usr/bin/env python
import sys

def main():
    candidates = set(sys.stdin.readline().split())
    num = int(sys.stdin.readline().rstrip())
    for __ in range(num):
        killed, repl = sys.stdin.readline().split()
        candidates.remove(killed)
        print(killed, list(candidates)[0])
        candidates.add(repl)
    print(' '.join(candidates))

if __name__ == '__main__':
    main()
