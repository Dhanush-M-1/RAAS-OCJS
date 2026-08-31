# input
k = int(input())
s = input()
answer = 1

if len(s) % k > 0:
  answer = -1
  print(answer)
else:
  # Counting letters
  dict={}
  for letter in s:
    if letter not in dict:
      dict[letter] = 1
    else:
      dict[letter] = dict[letter] + 1

  # Verifying if string is k-string

  for letter in dict:
    if dict[letter] % k > 0:
      answer = -1
      print(answer)
      break

  if answer == 1:
    #printing k-string
    for i in range(0, k):
      for letter in dict:
        print(letter * int(dict[letter]/k), end='', flush=True)
