arr=[int(x) for x in input().split()]
size=arr[0]
total=arr[1]
book_dict={'2':[],'10':[],'01':[]}
for i in range(size):
    book_arr=[int(x) for x in input().split()]
    if book_arr[1]==1 and book_arr[2]==1:
        book_dict['2'].append(book_arr[0])
    elif book_arr[1]==1 and book_arr[2]==0:
        book_dict['10'].append(book_arr[0])
    elif book_arr[1]==0 and book_arr[2]==1:
        book_dict['01'].append(book_arr[0])
count10=len(book_dict['10'])
count01=len(book_dict['01'])
count2=len(book_dict['2'])
result=0
book_dict['10'].sort()
book_dict['01'].sort()
if count10+count2>=total and count01+count2>=total:
    for i in range(min(count01,count10)):
        book_dict['2'].append(book_dict['01'][i]+book_dict['10'][i])
    book_dict['2'].sort()
    result=sum(book_dict['2'][:total])
    print(result)
else:
    print(-1)

