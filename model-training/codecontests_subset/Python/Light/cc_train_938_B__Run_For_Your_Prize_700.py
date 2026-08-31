n = int(input())
l = list(map(int, input().split()))
me = 1
fr = 1000000
for i in l:
    if i <= 500000:
        if me < i:
            me = i
    else:
        if fr > i:
            fr = i
print(max(1000000 - fr, me - 1))
