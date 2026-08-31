init_victims = list(map(str, input().split()))
next_victims = []
current_victims = init_victims
t = int(input())
for x in range(t):
    next_victims += list(map(str, input().split()))
print(' '.join(init_victims))
while t != 0:
    current_victims.remove(next_victims.pop(0))
    current_victims.append(next_victims.pop(0))
    print(' '.join(current_victims))
    t -= 1
