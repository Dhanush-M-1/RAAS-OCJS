import sys
from typing import List, Union


def rl(int_: bool = True, is_split: bool = True) -> Union[List[str], List[int]]:
    if int_:
        return [int(w) for w in sys.stdin.readline().split()]
    if is_split:
        return [w for w in sys.stdin.readline().split()]
    return sys.stdin.readline().strip()


lines = sys.stdin.read().split("\n")
n = len(lines)

names = set()
t = 0
l = 0
for i in range(n - 1):
    line = lines[i]
    if line[0] == "+":
        names.add(line[1:].strip())
        l += 1
    elif line[0] == "-":
        names.remove(line[1:].strip())
        l -= 1
    else:
        t += l * len(line.strip().split(":")[1])
print(t)
