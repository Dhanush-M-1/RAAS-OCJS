n = int(input())

raw = [int(i) for i in input().split()]
first = [int(i) for i in input().split()]
second = [int(i) for i in input().split()]

raw.sort()
first.sort()
second.sort()

check = 1
for i in range(len(first)):
    if(raw[i] != first[i]):
        print(raw[i])
        check = 0
        break
if(check):
    print(raw[-1])

check = 1
for i in range(len(second)):
    if(first[i]!=second[i]):
        print(first[i])
        check = 0
        break
if(check):
    print(first[-1])
