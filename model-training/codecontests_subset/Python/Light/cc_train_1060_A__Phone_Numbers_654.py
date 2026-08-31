#!/usr/bin/python3
from collections import Counter

def readint():
    return int(input())


def readline():
    return [int(c) for c in input().split()]


def main():
    no_cards = readint()
    cards = [int(c) for c in input()]

    cnt = Counter(cards)
    print(min(cnt[8], (sum(cnt.values())) // 11))
    


if __name__ == '__main__':
    main()
