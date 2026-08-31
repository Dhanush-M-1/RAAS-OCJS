import sys
input = iter(sys.stdin.read().splitlines()).__next__

t = int(input())
output = []
for _ in range(t):
    poem = input()
    # every palindrome contains a length-2 or length-3 palindrome substring
    # break length-2 palindromes by changing second character optimally
    # also change last for length 3
    ops = 0
    changed = set()
    for i in range(len(poem)-2):
        if i in changed:
            continue
        if i+1 not in changed and poem[i] == poem[i+1]:
            ops += 1
            # if poem[i] == poem[i+2]:
            #     changed.add(i)
            # else:
            #     changed.add(i+1)
            changed.add(i+1)
        if i+2 not in changed and poem[i] == poem[i+2]:
            ops += 1
            changed.add(i+2)
    if len(poem) >= 2 and len(poem)-2 not in changed and len(poem)-1 not in changed and poem[-2] == poem[-1]:
        ops += 1
    output.append(ops)
print(*output, sep="\n")