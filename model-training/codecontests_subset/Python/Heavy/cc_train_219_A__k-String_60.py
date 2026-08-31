k = int(input())

letters = input()

alphabet = 'abcdefghijklmnopqrstuvwxyz'
letter_mapping = [0] * 26

for letter in letters:
  for letter_idx, letter_alphabet in enumerate(alphabet):
    if letter == letter_alphabet:
      letter_mapping[letter_idx] += 1
      break
k_string = ''
solution = True

for number_idx, number in enumerate(letter_mapping):
  if number == 0:
    continue
  if int(number % k) != 0:
    solution = False
    break
  letter_mapping[number_idx] = int(number / k)

answer_string = ''
if solution:
  for count in range(max(letter_mapping)):
    for letter_idx, letter_alphabet in enumerate(alphabet):
      if letter_mapping[letter_idx] > 0:
        letter_mapping[letter_idx] -= 1
        k_string = k_string + letter_alphabet
  for count in range(k):
    answer_string = answer_string + k_string
  print(answer_string)
else:
  print(-1)
	 					    	 	   	 				 	 	 		