digits = int(input())

phn_number = input()

print(min((digits // 11) , phn_number.count('8')))
