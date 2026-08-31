
n=int(input())
s1=input().split()
s1=sorted(s1)
s2=input().split()
s2=sorted(s2)
s2.append(0)
s3=input().split()
s3=sorted(s3)
s3.append(0)
for i in range(len(s1)):
        if int(s1[i])-int(s2[i])!=0:
            print(s1[i])
            break


for i in range(len(s2)):
        if int(s2[i])-int(s3[i])!=0:
            print(s2[i])
            break
