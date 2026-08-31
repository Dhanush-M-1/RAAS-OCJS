noOfbuckets , garden = map(int , input().split(" "))

buckets_length = list(map(int , input().split(" ")))

can_choose = [i for i in buckets_length if garden % i == 0]
choosed_bucket = max(can_choose)

print(garden // choosed_bucket)


