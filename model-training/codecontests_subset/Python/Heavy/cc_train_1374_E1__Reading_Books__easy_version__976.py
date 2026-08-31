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
if len(alice) + len(together) < k or len(bob) + len(together) < k:
    print('-1')
    exit()
alice.sort(reverse=True)
bob.sort(reverse=True)
together.sort(reverse=True)
time = 0
for i in range(k):
    if len(alice) and len(bob) and len(together):
        if together[-1] <= alice[-1] + bob[-1]:
            time += together[-1]
            together.pop()
        else:
            time += alice[-1] + bob[-1]
            alice.pop()
            bob.pop()
    elif len(together):
        time += together[-1]
        together.pop()
    else:
        time += alice[-1] + bob[-1]
        alice.pop()
        bob.pop()
print(str(time))