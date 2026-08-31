n,k=list(map(int,input().split()))
books=[[],[],[],[]]
for i in range(n):
    s=list(map(int,input().split()))
    if s[1]==1 and s[2]==1:
        books[2].append(s[0])
    elif s[2]==1:
        books[1].append(s[0])
    elif s[1]==1:
        books[0].append(s[0])

if (len(books[0])+len(books[2]))<k or (len(books[1])+len(books[2]))<k:
    print(-1)
else:
    for x in books:
        x.sort()
    t=0
    al=0
    bl=0
    fi=0
    si=0
    can=True
    while (al<k) or (bl<k):
        if fi<len(books[0]) and fi<len(books[1]) and si<len(books[2]):
            #compare
            c1=books[0][fi]+books[1][fi]
            c2=books[2][si]
            if c1<c2:
                al += 1
                bl += 1
                t = t + c1
                fi=fi+1
            else:
                al += 1
                bl += 1
                t = t + c2
                si=si+1
        elif fi==len(books[0]):
            #For alice take leftovers from both
            needed = k - al
            t = t + sum(books[2][si:si+needed])
            break
        elif fi==len(books[1]):
            #For bob take leftovers from both
            needed = k - bl
            t = t + sum(books[2][si:si+needed])
            break
        elif si==len(books[2]):
            #take cheapest from indiv
            needed = k - al
            t = t + sum(books[0][fi:fi+needed])
            needed = k - bl
            t = t + sum(books[1][fi:fi+needed])
            break
        else:
            can=False
            break
    if can:
        print(t)
    else:
        print(-1)