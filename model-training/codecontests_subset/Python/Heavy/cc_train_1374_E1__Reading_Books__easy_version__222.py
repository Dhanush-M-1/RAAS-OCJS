from sys import stdin, stdout
input = stdin.readline
print = stdout.write
n, k = map(int, input().split())
alice, bob, together = [], [], []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a and b:
        together += t,
    elif a:
        alice += t,
    elif b:
        bob += t,
sa, sb, st = len(alice), len(bob), len(together)
if sa + st < k or sb + st < k:
    print('-1')
    exit()
sa -= 1
sb -= 1
st -= 1
alice.sort(reverse=True)
bob.sort(reverse=True)
together.sort(reverse=True)
time = 0
for i in range(k):
    if sa < 0 or sb < 0:
        time += together[st]
        st -= 1
    elif st < 0:
        time += alice[sa] + bob[sb]
        sa -= 1
        sb -= 1
    else:
        if together[st] <= alice[sa] + bob[sb]:
            time += together[st]
            st -= 1
        else:
            time += alice[sa] + bob[sb]
            sa -= 1
            sb -= 1
print(str(time))