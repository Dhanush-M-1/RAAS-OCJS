# get the length of the garden, buckets
file = [* open(0)]
_, garden = list(map(int, file[0].split()))
buckets = list(map(int, file[1].split()))

# choose a bucket
hours = 101
for i in buckets:
    new_hour = garden // i
    if garden % i == 0 and new_hour <= hours:
        hours = new_hour
# output hour
print(hours)

