q = int(input())
M = [list(map(int, input().split())) for i in range(q)]
S =[]
#x = 1
l = len(S)

for i in range(q):
   x = 1
   while True:
       if x < M[i][0] or x > M[i][1]:
           if x % M[i][2] == 0:
               S.append(x)
               break
           else:
               if x < M[i][2]:
                   x = M[i][2]
               else:
                   x = x+(M[i][2]-x % M[i][2])
       else:
           if M[i][2] >= M[i][0]:
               x = M[i][1]+1
           elif M[i][2] < M[i][0]:
               x = 2


for i in S:
    print(i)