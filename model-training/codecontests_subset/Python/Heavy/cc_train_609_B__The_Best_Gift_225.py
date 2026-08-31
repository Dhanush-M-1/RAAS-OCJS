duplicated_keys = {}


def calculate_chinh_hop_of_2(number_books):
    return int(number_books * (number_books - 1) / 2)


number_books, number_genders = list(map(int, input().split()))
number_data = list(map(int, input().split()))
number_of_choosing_books = calculate_chinh_hop_of_2(number_books)

# get books for per gender
for book in number_data:
    if book not in duplicated_keys:
        duplicated_keys[book] = 1
    else:
        duplicated_keys[book] += 1
for value in duplicated_keys.values():
    number_of_choosing_books -= calculate_chinh_hop_of_2(value)
print(number_of_choosing_books)
