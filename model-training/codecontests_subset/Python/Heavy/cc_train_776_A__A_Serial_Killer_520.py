import sys


def find_target_pair(prev, nex):
    new = [None, None]
    if prev[0] == nex[0]:
        new[1] = nex[1]
        new[0] = prev[1]
    elif prev[0] == nex[1]:
        new[1] = prev[1]
        new[0] = nex[0]

    if prev[1] == nex[0]:
        new[0] = prev[0]
        new[1] = nex[1]
    elif prev[1] == nex[1]:
        new[1] = prev[0]
        new[0] = nex[0]
    return new


def solution(prev, input):
    print(prev[0], prev[1])
    for pair in input:
        new = find_target_pair(prev, pair)
        print(new[0], new[1])
        prev = new

if __name__ == '__main__':
    inp = list(sys.stdin.read().split('\n'))
    prev = list(inp[0].split())
    input = [i.split() for i in inp[2:-1]]
    assert (int(inp[1]) == len(input)), "Invalid input"
    solution(prev, input)