n=int(input())
error=sorted(list(map(int,input().split())))
second=sorted(list(map(int,input().split())))
third=sorted(list(map(int,input().split())))
for i in range(n-1):
    if error[i]!=second[i]:
        print(error[i])
        break
    else:
        if i==n-2:
            print(error[n-1])
for i in range(n-2):
    if second[i]!=third[i]:
        print(second[i])
        break
    else:
        if i==n-3:
            print(second[n-2])
