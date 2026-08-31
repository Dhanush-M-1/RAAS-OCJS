a, b = [int(x) for x in input().split()]
num_whole = a
num_ended = 0
ans = 0
while num_whole > 0:
    ans += num_whole
    num_ended = num_ended + num_whole
    num_whole = num_ended // b
    num_ended = num_ended % b
print(ans)
