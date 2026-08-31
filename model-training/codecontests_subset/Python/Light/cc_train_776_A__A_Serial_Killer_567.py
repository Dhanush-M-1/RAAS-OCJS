from collections import deque

def main():
    from sys import stdin
    lines = deque(line.strip() for line in stdin.readlines())
    # lines will now contain all of the input's lines in a list
    a, b = lines.popleft().split()
    n = int(lines.popleft())
    print(a, b)
    for i in range(n):
        killed, replace = lines.popleft().split()
        if a == killed:
            a = replace
        else:
            b = replace
        print(a, b)

if __name__ == '__main__':
    main()
