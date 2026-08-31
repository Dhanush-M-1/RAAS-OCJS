n=int(input())
s=[sum(map(int,input().split()))for i in range(3)]
print(s[0]-s[1])
print(s[1]-s[2])
