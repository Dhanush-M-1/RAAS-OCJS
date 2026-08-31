#! /usr/bin/python
# kmwho
# Codeforces 400 D2

def solve():
    options = input().strip().split()
    n       = int(input())
    print(options[0], options[1])
    for i in range(n):
        victim, newguy = input().strip().split()
        options.remove(victim)
        options.append(newguy)
        print(options[0], options[1])

def main():
	solve()

main()

