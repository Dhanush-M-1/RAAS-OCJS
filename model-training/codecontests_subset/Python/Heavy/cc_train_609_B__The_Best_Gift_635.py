#609 B Best Gift
#1. Create a list of genre and count how many book of each genre
#2. with each genre, number of way to choose gift: number_of_books_in_this_genre * (number_of_books_of_other_genres)

number_of_books, number_of_genres = map(int, input().split())

count_genres = number_of_genres*[0]

type_of_each_book = list(map(int, input().split()))

for book in type_of_each_book:
	count_genres[book-1] += 1
	
total_ways = 0

for index, count in enumerate(count_genres):
	total_ways += count * sum(count_genres[index+1:])
	
print(total_ways)