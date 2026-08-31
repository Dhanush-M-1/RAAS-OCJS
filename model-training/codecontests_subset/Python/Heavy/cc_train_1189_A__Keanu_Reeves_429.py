##n = int(input())
##
##seq = [int(x) for x in input().split()]
##
##q = int(input())
###new = []
##
##for i in range(1, q+1):
##    candy = 0
##    
##    l, r = map(int, input().split())
##
##    sub = seq[l-1:r]
##
##    while(len(sub)>1):
##        last = len(sub)
##        n#ew = []
##        for j in range(0, len(sub)-1, 2):
##            s = sub[j] + sub[j+1]
##            if s>=10:
##                candy += 1
##            sub.append(s%10)
##            #print(new)
##        sub = sub[last:]
##
##    print(candy)
##        
##            
        
##n = int(input())
##arr = [int(x) for x in input().split()]
##
##arr.sort(reverse = True)
##
##a = arr[0]
##b = arr[1]
##c = arr[2]
##
##if b + c <= a:
##    print('NO')
##else:
##    print('YES')
##    print(b, a, c, end=' ')
##    for i in range(3, len(arr)):
##        print(arr[i], end= ' ')

n = int(input())
s= input()

ones =0
zeroes = 0

if n%2==1:
    print(1)
    print(s)
else:    
    for i in s:
        if i =='1':
            ones+=1
        else:
            zeroes+=1
    if ones == zeroes:
        print(2)
        print(s[0], s[1:])
    else:
        print(1)
        print(s)

