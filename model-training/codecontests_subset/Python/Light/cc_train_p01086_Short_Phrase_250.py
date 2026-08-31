s = [5,7,5,7,7]


def solve(n):
    num = [len(input()) for _ in range(n)]

    for i in range(n):
         c = 0
         k = 0
         for j in range(i,n):
             c+= num[j]
             if c==s[k]:
                 k+=1
                 c = 0
                 if k == 5:
                     print(i+1)
                     return
             if c > s[k]:
                 break


while 1:
    n = int(input())
    if n == 0:
        break
    solve(n)
