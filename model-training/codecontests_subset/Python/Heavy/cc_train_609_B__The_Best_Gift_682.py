def function():
    totalDrives=int(input())
    fileSize=int(input())
    drives=[]
    for element in range(totalDrives):
        temp=int(input())
        drives.append(temp)
    drives.sort()
    currentSize=0
    driveCount=0
    while(currentSize<fileSize):
        currentSize+=drives.pop()
        driveCount+=1
    return driveCount

def genre():
    temp=input().split()
    bookCount=int(temp[0])
    genres=int(temp[1])
    temp=input().split()
    books=list(map(int, temp))
    books.sort()

    temp=0
    bookGenre=[0]*genres
    for book in books:
        if (book==temp):
            bookGenre[book-1]+=1
        else:
            temp+=1
            bookGenre[book-1]=1
            
    combinations=0
    for genre in bookGenre:
        combinations+=genre*(bookCount-genre)
    return int(combinations/2)
        
    

print(genre())
