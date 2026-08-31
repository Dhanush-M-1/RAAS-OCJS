n, k = map(int, input().split())

l = list(map(int, input().split()))
l.sort(reverse = True)

for i in l:
  if k%i == 0:
    print(k//i)
    break
