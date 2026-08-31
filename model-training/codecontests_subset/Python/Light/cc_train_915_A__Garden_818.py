bucket_count, seg_len = [int(x) for x in input().split()]
bucket_size  = [int(x) for x in input().split()]
mins = int(10e9)
for i in bucket_size:
    if seg_len % i == 0:
        mins = min(mins, seg_len//i)
print(mins)