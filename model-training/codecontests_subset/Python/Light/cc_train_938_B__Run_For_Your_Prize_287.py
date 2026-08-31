n = int(input())

prices = list(map(int, input().split()))

you = 1
friend = 1_000_000
midle = 500_000
time_m = 0
time_f = 0

second_half = []
for p in prices:
    if p <= midle:
        time_m += (p - you)
        you = p
    else:
        second_half.append(p)

second_half = sorted(second_half, reverse=True)

for p in second_half:
        time_f += (friend - p)
        friend = p

print(max(time_f, time_m))



