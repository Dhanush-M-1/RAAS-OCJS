s=input().split()
n=int(input())
while(n):
    v=input().split()
    for i in s:
        print(i, end=" ")
    print()
    s=[v[1] if x==v[0] else x for x in s]
    n-=1
for i in s:
        print(i, end=" ")
print()