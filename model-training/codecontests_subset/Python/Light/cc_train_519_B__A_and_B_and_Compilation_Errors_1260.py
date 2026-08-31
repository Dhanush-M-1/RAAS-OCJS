n = int(input())
first = input().split()
second = input().split()
third = input().split()
first.sort()
second.sort()
third.sort()
for i in range(n-1):
    if first[i]!=second[i]:
        print(first[i])
        break
else:
    print(first[-1])
for i in range(n-2):
    if third[i]!=second[i]:
        print(second[i])
        break
else:
    print(second[-1])