def num_of_hours(bucket:int,length:int):
    if(length%bucket == 0):
        return length//bucket
    else:
        return None

a = input().split(" ")
length = int(a[1])
no_of_buckets = int(a[0])
list_of_buckets = []
hours = []
buckets = input().split(" ")
for bucket in buckets:
    list_of_buckets.append(int(bucket))
for bucket in list_of_buckets:
    num_of_hrs = num_of_hours(bucket,length)
    if(num_of_hrs != None):
        hours.append(num_of_hrs) 
lowest = hours[0]
for low in hours:
    if(lowest > low):
        lowest = low
print(lowest)