a = int(input(""))
b = input("")

occurences_of_eight = 0

for i in range(len(b)):
    if b[i] == "8":
        occurences_of_eight = occurences_of_eight + 1

max_phone_numbers = int(len(b) / 11)

print(min(occurences_of_eight, max_phone_numbers))
