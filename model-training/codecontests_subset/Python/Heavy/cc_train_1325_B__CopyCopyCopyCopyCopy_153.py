def answer():
    n=int(input())
    while n:
        times = int(input())
        a = input().split()
        a = [int(x) for x in a]
        them = len(set(a))
        done=0
        if them<=times:
            print(them)
            done=1
        if not done:
            visited=[]
            i=0
            ans=1
            while i<len(a) and ans<len(a)-len(visited):
                j=i
                temp=1
                thing=a[j]
                while j<len(a):
                    if a[j]>thing:
                        visited.append(j)
                        thing=a[j]
                        temp+=1
                    j+=1
                i+=1
                while i in visited:
                    i+=1
                if ans<temp:ans=temp

            i=0
            while i+1<times and ans<them:
                i+=1
                ans+=1
            print(ans)


        n-=1
answer()