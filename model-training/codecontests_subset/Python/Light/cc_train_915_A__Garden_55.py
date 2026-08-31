n, k = map(int, input().split())
a = [int(num) for num in input().split()]

mina = k
for i in range(0, len(a)):
    if k%a[i] == 0 and k/a[i] < mina:
        mina = k/a[i]
print(int(mina))

