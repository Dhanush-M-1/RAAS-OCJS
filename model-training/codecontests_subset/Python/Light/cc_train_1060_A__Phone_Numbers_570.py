n = int(input())
st = input()

count8 = 0
for k in st:
    if k == "8":
        count8 += 1

res = min( int(len(st)/11), count8 )

print(res)