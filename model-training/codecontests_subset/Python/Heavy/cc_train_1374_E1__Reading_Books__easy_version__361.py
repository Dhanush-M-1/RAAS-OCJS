from sys import stdin, stdout

n, k = map(int, stdin.readline().split())
alice = []
bob = []
together = []
for _ in range(n):
    t, a, b = map(int, stdin.readline().split())
    if a and b:
        together += t,
    elif a:
        alice += t,
    elif b:
        bob += t,
sa, sb, st = len(alice), len(bob), len(together)
if sa + st < k or sb + st < k:
    stdout.write('-1')
    exit()
alice.sort(reverse=True)
bob.sort(reverse=True)
together.sort(reverse=True)
time = 0
for _ in range(k):
    if sa and sb and st:
        if together[-1] < alice[-1] + bob[-1]:
            time += together[-1]
            together.pop()
            st -= 1
        else:
            time += alice[-1] + bob[-1]
            alice.pop()
            bob.pop()
            sa -= 1
            sb -= 1
    elif st:
        time += together[-1]
        together.pop()
        st -= 1
    else:
        time += alice[-1] + bob[-1]
        alice.pop()
        bob.pop()
        sa -= 1
        sb -= 1
stdout.write(str(time))