from operator import itemgetter
#int(input())
#map(int,input().split())
#[list(map(int,input().split())) for i in range(q)]
#print("YES" * ans + "NO" * (1-ans))
name = input().split()
n = int(input())
print(name[0],name[1])
for i in range(n):
    names = input().split()
    if name[0] == names[0]:
        name[0] = names[1]
    else:
        name[1] = names[1]
    print(name[0],name[1])
