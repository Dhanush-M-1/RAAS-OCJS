first_nums = input().split()
len_matris = int(first_nums[0])
k = int(first_nums[1])
books = []
for i in range(len_matris):
    book = input().split()
    books.append([int(x) for x in book])
 
liked_books = list(filter(lambda x: x[1] == 1 and x[2] ==1,books))
books_0_1 = list(filter(lambda x: x[1] == 0 and x[2] == 1,books))
books_1_0 = list(filter(lambda x: x[1] == 1 and x[2] == 0,books))
books_0_1.sort()
books_1_0.sort()
liked_books.sort()
result_books = []

for i in liked_books:
    result_books.append(i[0])

for a,b in zip(books_1_0,books_0_1):
    result_books.append(a[0]+b[0])


result_books.sort()
if len(books_1_0) + len(liked_books) < k or len(books_0_1) + len(liked_books) < k:
    print(-1)
else:
    print(sum(result_books[:k]))