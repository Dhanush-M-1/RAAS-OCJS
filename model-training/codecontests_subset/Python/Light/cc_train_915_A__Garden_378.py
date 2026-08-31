inp = input().split(" ")
k = int(inp[1])
inp = input().split(" ")
cb = 0
for bs in inp:
    b = int(bs)
    if b > cb and k % b == 0:
        cb = b
if cb > 0:
    print('{:d}'.format(int(k/cb)))