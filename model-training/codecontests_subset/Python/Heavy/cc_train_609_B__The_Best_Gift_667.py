intro = input()
variables = intro.split(" ")
books = variables[0]
genres = variables[1]

# genreLine = input()
# genreList = [int(genre) for genre in genreLine.split(" ")]

choices = 0
# for index1 in range(len(genreList)):
#     for book in genreList[index1 + 1::]:
#         if genreList[index1] != book:
#             choices += 1

bookGenreDict = {}
genreLine = input()
for genre in genreLine.split(" "):
    if genre in bookGenreDict:
        bookGenreDict[genre] += 1
    else:
        bookGenreDict[genre] = 1
bookGenreList = []
for genre in bookGenreDict:
    bookGenreList.append(bookGenreDict[genre])
    
choices = 0
for book1 in range(len(bookGenreList) - 1):
    for book2 in range(book1 + 1,len(bookGenreList)):
        choices += bookGenreList[book1] * bookGenreList[book2]

print(choices)