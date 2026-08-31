from itertools import chain

n = int(input())

def func_to_n(func, n=n):
    arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    arr = arr[:n]
    _ = list(map(func, arr))

def tight_loop(c):
    global dist
    dist[b][c] = min(dist[b][c],
                     dist[b][a] + dist[a][c])

def small_loop(bb):
    global b
    b = bb
    func_to_n(tight_loop)

def middle_loop(aa):
    global a
    a = aa
    func_to_n(small_loop)

def big_loop():
    func_to_n(middle_loop)

def add_line(ignored):
    global dist
    dist.append(list(map(int, input().split())))

dist = []
func_to_n(add_line)

big_loop()

print(max(chain.from_iterable(dist)))