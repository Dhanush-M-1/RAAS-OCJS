from collections import deque

def I(): return list(map(int, input().split()))


dic = {}
x0, y0, x1, y1 = I()
for i in range(int(input())):
    r, a, b = I()
    while a != b + 1:
        tup = (r, a)
        dic[tup] = -1
        a += 1
x = [-1, -1, -1, 0, 0, 1, 1, 1]
y = [-1, 0, 1, -1, 1, -1, 0, 1]
dic[(x0, y0)] = 0
queue = deque([(x0, y0)])
while len(queue) > 0:
    popped = queue.popleft()
    for i in range(8):
        new_square = (popped[0] + x[i], popped[1] + y[i])
        if new_square in dic and dic[new_square] == -1:
            queue.append(new_square)
            dic[new_square] = dic[popped] + 1

print(dic[(x1, y1)])

