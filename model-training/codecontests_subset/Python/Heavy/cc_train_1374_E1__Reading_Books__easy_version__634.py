n,k=map(int,input().split())
both=[]
alice=[]
bob=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        both.append(t)
    elif a==1 and b==0:
        alice.append(t)
    elif a==0 and b==1:
        bob.append(t)
both.sort(reverse=True)
alice.sort(reverse=True)
bob.sort(reverse=True)
a=len(both)+len(alice)
b=len(both)+len(bob)
if a<k or b<k:
    print(-1)
else:
    a,b=k,k
    ans=0
    while a or b:
        if a>0 and b>0:
            if alice!=[] and bob!=[]:
                if both!=[]:
                    if alice[-1]+bob[-1]<both[-1]:
                        ans+=alice.pop()+bob.pop()
                        a-=1
                        b-=1
                    else:
                        ans+=both.pop()
                        a-=1
                        b-=1
                else:
                    ans+=alice.pop()
                    ans+=bob.pop()
                    a-=1
                    b-=1
            else:
                ans+=both.pop()
                a-=1
                b-=1
        elif a>0:
            if alice==[]:
                ans+=both.pop()
                a-=1
            elif both==[]:
                ans+=alice.pop()
                a-=1
            else:
                if alice[-1]<both[-1]:
                    ans+=alice.pop()
                    a-=1
                else:
                    ans+=both.pop()
                    a-=1

        elif b > 0:
            if bob == []:
                ans += both.pop()
                b -= 1
            elif both == []:
                ans += bob.pop()
                b -= 1
            else:
                if bob[-1] < both[-1]:
                    ans += bob.pop()
                    b -= 1
                else:
                    ans += both.pop()
                    b -= 1
    print(ans)


