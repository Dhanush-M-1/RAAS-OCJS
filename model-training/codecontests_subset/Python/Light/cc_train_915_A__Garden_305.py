string = input().split(' ')

n = int(string[0])
k = int(string[1])

buckets = input().split(' ')

time = float('inf')

for num in buckets:
  if k % int(num) == 0:
    timeTaken = k // int(num)
    if timeTaken < time:
      time = timeTaken

print(time)