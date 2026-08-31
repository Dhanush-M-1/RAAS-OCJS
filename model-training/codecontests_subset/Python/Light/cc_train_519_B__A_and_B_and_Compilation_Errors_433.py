n=int(input())
first=[int(x) for x in input().split()]
second=[int(x) for x in input().split()]
third=[int(x) for x in input().split()]
first.sort()
second.sort()
third.sort()
error1=[first[-1]]
error2=[second[-1]]
for i in range(len(second)):
    if first[i]!=second[i]:
        error1.append(first[i])
        break
for i in range(len(third)):
    if second[i]!=third[i]:
        error2.append(second[i])
        break
print(min(error1))
print(min(error2))