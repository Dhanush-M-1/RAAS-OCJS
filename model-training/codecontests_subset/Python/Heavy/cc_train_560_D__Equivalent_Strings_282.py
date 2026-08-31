def comparassion(palavra_1, palavra_2):
  if(palavra_1 == palavra_2):
    return True
  if(len(palavra_1) % 2 != 0 or len(palavra_2) %2 !=0):
    return False
  center = len(palavra_1)//2

  left_1= palavra_1[:center]
  right_1 = palavra_1[center:]

  left_2= palavra_2[:center]
  right_2 = palavra_2[center:]

  return (comparassion(left_1, right_2) and comparassion(right_1, left_2)) or(comparassion(left_1, left_2) and comparassion(right_1, right_2)) 

palavra_1 = input()
palavra_2 = input()
if comparassion(palavra_1, palavra_2):
  print("YES")
else:
  print("NO")