from collections import Counter
n, k = list(map(lambda x: int(x),input().split()))
cnt = n
while(n>0):
    temp_ = int(n/k)
    n = temp_ + n%k
    cnt+=temp_
    if n<k:
        break

print(cnt)

