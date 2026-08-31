n,k = map(int, input().split())

res = 10000000000000
for x in map(int, input().split()):
    if k%x == 0 and k//x < res:
        res = k//x
print(res) 