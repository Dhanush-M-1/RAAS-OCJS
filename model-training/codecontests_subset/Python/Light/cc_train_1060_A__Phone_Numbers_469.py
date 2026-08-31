def phone_numbers():

  n = int(input())
  s = input()

  if (n // 11 == 0):

    print(0)
    return 0

  k = 0

  for i in range(0, n):

    if (s[i] == "8"):

      k += 1

    if (k == n // 11):

      print(k)
      return 0

  if (k == 0):

    print(0)

  else:

    print(k)
    
  return 0

phone_numbers()