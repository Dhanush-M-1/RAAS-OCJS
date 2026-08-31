import collections
t=int(input())
for _ in range(0,t):
    realn=int(input())
    n = realn
    len3 = 0
    len2 = 0
    if n == 1:
        print(0)
    elif n % 3 != 0:
        print(-1)
    else:
        while n >= 3:
            if n % 3 == 0:
                len3+=1
                n = n // 3
            else:
                break
        while n >= 2:
            if n % 2 == 0:
                len2+=1
                n = n // 2
            else:
                break
        #print("len2:",len2,"len3:",len3)
        if len2 > len3:
            print(-1)
        else:
            multi = len3 - len2
            mul = len3
            for _ in range(0,multi):
                realn *= 2
            for _ in range(0,mul):
                realn //= 6
            #print("n:",n)
            if realn == 1:
                print(multi + mul)
            else:
                print(-1)
        """
        else:
            q=collections.deque()
            q.append([n,0])
            while q:
                #print(q)
                tmp, tried = q.popleft()
                if tmp == 1:
                    print(tried)
                    break
                else:
                    q.append([tmp*2,tried+1])
                    if tmp // 6 != 0:
                        q.append([tmp//6,tried+1])
        """