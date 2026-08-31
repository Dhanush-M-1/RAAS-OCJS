import sys
input=sys.stdin.buffer.readline

n,k=[int(x) for x in input().split()]

books=[] #(ti,ai,bi)
for _ in range(n):
    books.append([int(x) for x in input().split()])
books.sort(key=lambda x:x[0]) #sort by ti asc

aliceBooks=[0] #stores sum of book costs
bobBooks=[0]
bothBooks=[0]

for i in range(n):
    ti,ai,bi=books[i]
    if ai==1 and bi==0:
        aliceBooks.append(aliceBooks[-1]+ti)
    if ai==0 and bi==1:
        bobBooks.append(bobBooks[-1]+ti)
    if ai==1 and bi==1:
        bothBooks.append(bothBooks[-1]+ti)

if min(len(aliceBooks)-1,len(bobBooks)-1)+len(bothBooks)-1<k:
    print(-1) #impossible
else:
    minT=99999999999999999999999999
    for cnt in range(len(bothBooks)-1,-1,-1):
        if cnt>k:
            continue
        if k-cnt>=min(len(aliceBooks),len(bobBooks)):
            break
        minT=min(minT,bothBooks[cnt]+aliceBooks[k-cnt]+bobBooks[k-cnt])
    print(minT)