n , k = map(int , input().split())
books = []
alice = []
bobs = []
for _ in range(n): 
    t , a , b = map(int , input().split())
    if (a== 1 and b==1): 
        books.append(t)
    elif (a == 1): 
        alice.append(t)
    elif (b==1):
        bobs.append(t)


books = sorted(books)
alice = sorted(alice)
bobs = sorted(bobs)

b = 0 
ab = 0 
count = 0 
ans = 0 
while (count< k and (b < len(books) and (ab < len(alice) and ab < len(bobs)))):
    if (books[b] <= alice[ab]+bobs[ab]): 
        ans += books[b]
        b+=1 
    else : 
        ans += (alice[ab] + bobs[ab])
        ab+=1 
    count+=1 
if (count == k ): 
    print(ans)
else : 
    while(count< k and (b < len(books) )): 
        ans += books[b]
        b+=1 
        count+=1 
        
    while(count< k and(ab < len(alice) and ab < len(bobs))): 
        ans += (alice[ab] + bobs[ab])
        ab+=1
        count+=1 
    if(count < k ): 
        print(-1)
    else : 
        print(ans)




