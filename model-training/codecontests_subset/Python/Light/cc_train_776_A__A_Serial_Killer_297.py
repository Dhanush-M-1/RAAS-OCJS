import sys

rl = lambda: sys.stdin.readline()
victims = rl().strip().split(' ')


def print_list():
    print('{} {}'.format(victims[0], victims[1]))

print_list()

num_line = int(rl())
for _ in range(num_line):
    victim, subst = rl().strip().split(' ')
    if victims[0] == victim:
        victims[0] = subst
    else:
        victims[1] = subst
    print_list()
