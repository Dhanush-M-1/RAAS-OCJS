n=int(input())
s1=list(input().split(" "))
s1.sort()
s2=list(input().split(" "))
s2.sort()
s3=list(input().split(" "))
s3.sort()
for i in range(n-1):
    if s1[i]!=s2[i]:
        print(s1[i])
        break
else:print(s1[n-1])
for i in range(n-2):
    if s2[i]!=s3[i]:
        print(s2[i])
        break
else:print(s2[n-2])
