v1, v2 = map(str, input().split())
t = int(input())
print(v1,v2)
for i in range(t):
    k, r = map(str,input().split())
    if(k == v1):
        v1 = r
        print(v1,v2)
    else:
        v2 = r
        print(v1,v2)
    