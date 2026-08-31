n, k = [int(w) for w in input().split()]
list = [int(w) for w in input().split()]

min = 10000000;
for i in list:
    if k % i == 0:
        tmp = k/i
        if tmp < min:
            min = tmp

print(int(min))