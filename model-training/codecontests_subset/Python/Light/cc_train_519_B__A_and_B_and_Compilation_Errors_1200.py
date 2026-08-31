n = int(input())
before = sorted([int(i) for i in input().split()])

for i in range(2):
    now = sorted([int(j) for j in input().split()])
  
    for k in range(n-1-i):
        if now[k] != before[k]:
            print(before[k])
            break
    else:
        print(before[n-1-i])

    before = now
