buckets, gard_length = list(map(int, input().split()))
len_per_hour = list(map(int, input().split()))
maximum = 0
for i in range(len(len_per_hour)):
    if len_per_hour[i] > maximum and gard_length % len_per_hour[i] == 0:
        maximum = len_per_hour[i]
print(gard_length // maximum)
