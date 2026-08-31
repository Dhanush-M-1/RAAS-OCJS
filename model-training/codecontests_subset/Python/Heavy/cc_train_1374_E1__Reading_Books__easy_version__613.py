n, k = map(int, input().split())

Books = []

Alice, Bob, Common_Books = [], [], []
for i in range(n):
    
    Book = tuple(map(int, input().split()))
    
    Books.append(Book)
    
Books = sorted(Books, key=lambda x:x[0])

# print(Books)
    
for Book in Books:
    
    if Book[1] == 1 and Book[2] == 1:
        if len(Common_Books) < k:
            Common_Books.append(Book)
        else:
            break
        
    else:
    
        if len(Alice) != k and Book[1] == 1:
            Alice.append(Book)
        
        if len(Bob) != k and Book[2] == 1:
            Bob.append(Book)

t = len(Common_Books)
        
if len(Alice) < k-t or len(Bob) < k-t:
    print(-1)
else:
    # print(Common_Books)
    # print(Alice, Bob)
    
    Min_time = 0
    a, iab, ic = 0, 0, 0
    
    while(a<k):
        if iab < len(Alice):
            A = Alice[iab]
        else:
            A = (float('inf'), 0, 0)
            
        if iab < len(Bob):
            B = Bob[iab]
        else:
            B = (float('inf'), 0, 0)
            
        if ic < len(Common_Books):
            C = Common_Books[ic]
        else:
            C = (float('inf'), 0, 0)
        
        if A[0]+B[0] < C[0]:
            Min_time += A[0]+B[0]
            iab += 1
        else:
            Min_time += C[0]
            ic += 1
        
        a += 1
        
    print(Min_time)
    
    
    