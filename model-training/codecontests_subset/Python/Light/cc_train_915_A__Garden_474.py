n,k = map(int, input().split(' '))
a = list(map(int, input().split(' ')))
out = k
for i in a:
    if k % i == 0 and k//i < out:
        out = k//i
print(out)        