n = int(input())
s1  = list(map(int,input().split()))
s2 = list(map(int,input().split()))
s3 = list(map(int,input().split()))

s1 = list(sorted(s1))
s2 = list(sorted(s2))
s3 = list(sorted(s3))

i=0
j=0
while i<len(s1) :
    if j<len(s2) and s1[i]==s2[j]:
        i+=1
        j+=1
    else:
        print(s1[i])
        break

i=0
j=0
while i<len(s2):
    if j<len(s3) and s2[i]==s3[j]:
        i+=1
        j+=1
    else:
        print(s2[i])
        break
