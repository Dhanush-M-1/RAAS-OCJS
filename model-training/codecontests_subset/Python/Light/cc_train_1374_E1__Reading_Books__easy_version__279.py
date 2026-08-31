n,k = [int(x) for x in input().split()]
books=[]
books_a=[]
books_b=[]

for i in range(n):

    b = [int(x) for x in input().split()]

    if b[1]==1 and b[2]==1:
        books.append(b[0])

    elif b[1]==1:
        books_a.append(b[0])

    elif b[2]==1:
        books_b.append(b[0])

books_a=sorted(books_a)
books_b=sorted(books_b)

z= min(len(books_a) , len(books_b))

for j in range(z):
    books.append(books_a[j] + books_b[j])
    
books=sorted(books)

ans=0

if len(books) < k:
    print(-1)
else:

    for f in range(k):
        ans+=books[f]

    print(ans)