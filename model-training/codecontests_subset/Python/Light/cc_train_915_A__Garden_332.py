s = input().split(' ')
buckets_n = s[0]
length = int(s[1])

buckets_vol = sorted(map(lambda x: int(x), input().split(' ')), reverse = True)
for b in buckets_vol:
    if b <= length and length % b == 0:
        print(int(length / b))
        break