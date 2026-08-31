# loop qua mang books neu mang booksPerGenre chua co genre cuon tren thi them gia tri moi chua genre va so luong cua genre do (1)
# neu mang booksPerGenre da chua genre cua cuon tren thi tang gia tri cua genre do len 1
# loop qua tung genre so lua chon cong them bang tich cua so sach trong genre hien tai voi so sach trong cac genre khac con lai

booksNumAndGenreNum = input().split()
booksNum = int(booksNumAndGenreNum[0])
genreNum = int(booksNumAndGenreNum[0])
books = list(map(int, input().split()))
booksPerGenre = []
for book in books:
    exist = False
    for books in booksPerGenre:
        if(books[0]==book):
            books[1] = books[1] + 1
            exist = True
    if(exist== False):
        booksPerGenre.append([book, 1])

choice = 0
for i in range(len(booksPerGenre) -1):
    for j in range(len(booksPerGenre)-1 - i):
        choice = choice + booksPerGenre[i][1]*booksPerGenre[j + i + 1][1]

print(choice)