sum_in, ex = [int(x) for x in input().strip().split()]
cnt = sum_in
while sum_in >= ex:
    cnt += int(sum_in/ex)
    sum_in = int(sum_in/ex) + sum_in % ex
print(cnt)