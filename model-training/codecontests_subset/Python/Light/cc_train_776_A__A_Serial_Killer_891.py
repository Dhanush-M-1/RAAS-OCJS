initial = input().split()
n = int(input())
trans = []
print(initial[0], initial[1])
for i in range(n):
    next = input().split()
    if initial[0] == next[0]:
        print(next[1], initial[1])
        initial[0] = next[1]
    if initial[1] == next[0]:
        print(initial[0], next[1])
        initial[1] = next[1]
