import sys

k = sys.stdin.readline()
st1 = sum([int(x) for x in (sys.stdin.readline()).split()])
st2 = sum([int(x) for x in (sys.stdin.readline()).split()])
st3 = sum([int(x) for x in (sys.stdin.readline()).split()])

print(st1 - st2)
print(st2 - st3)