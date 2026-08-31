N = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))

i = 0
while i < N-1 and a[i] == b[i]:
    i += 1
print(a[i])

j = 0
while j < N - 2 and b[j] == c[j]:
    j += 1
print(b[j])




