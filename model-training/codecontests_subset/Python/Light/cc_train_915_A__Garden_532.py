_, garden_length = map(int, input().split())
buckets = map(int, input().split())

min_hours = int(min([garden_length/bucket for bucket in buckets if garden_length % bucket == 0]))
print(min_hours)
