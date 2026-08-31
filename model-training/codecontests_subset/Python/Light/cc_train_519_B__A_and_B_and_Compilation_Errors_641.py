n=int(input())

s=list(map(int, input().split()))
s.sort()
s2=list(map(int, input().split()))
s2.sort()
state=0
for i in range(n-1):
    if s[i]!=s2[i]:
        print(s[i])
        state=1
        break

if state==0:
    print(s[n-1])

state=0

s3=list(map(int, input().split()))
s3.sort()

for i in range(n-2):
    if s2[i]!=s3[i]:
        print(s2[i])
        state=1
        break

if state==0:
    print(s2[n-2])