t = int(input())
while t:
    n = int(input())
    #x, y, n = map(int, input().split())
    #lst = list(map(int, input().split()))

    odd, even = 0, 0
    while(n%2==0):
        even += 1
        n = n//2

    while (n%3==0):
        odd+=1
        n = n//3

    if n==1:
        
        if even > odd:
            print(-1)

        else:
            x = abs(odd-even)
            print(max(odd, even) + x)
    else:
        print(-1)
    
    t-=1















#code
'''import string

alpha = string.ascii_uppercase

dic = {'POON', 'PLEE', 'SAME', 'POIE', 'PLEA', 'PLIE', 'POIN'}
start = 'TOON'
target = 'PLEA'

def fun():
    q = []
    q.append(start)
    level = 0
    while (len(q) > 0):
        q_len = len(q)
        level += 1
        for i in range(q_len):

            word = q.pop(0)
            for i in range(len(word)):
                x = word[i]

                for j in alpha:
                    new = word[:i] + j + word[i+1:]

                    if new == target:
                        return level + 1
                    if new not in dic:
                        continue

                    q.append(word)
                    dic.discard(word)


    return 0



print(fun())
                    
'''















#NEXT GREATER ELEMENT
'''t=int(input())

while t:
    n = int(input())
    lst = list(map(int, input().split()))

    
    
    stack = [lst[-1]]
    ans = [-1]
    for i in range(n-2, -1, -1):

        flag = 0
        while len(stack) > 0:
            x = stack[-1]
            if x > lst[i]:
                ans.append(x)
                break
            else:
                stack.pop()

        if len(stack) == 0:
            ans.append(-1)

        stack.append(lst[i])
                
        #print(i, stack)

    a = ans[::-1]
    print(*a)
        
                
    
    t-=1
'''
