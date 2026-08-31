password=input()
n=int(input())
words=[input() for i in range(n)]
first_letter=password[0]
second_letter=password[1]
if password in words:
      print("YES")
else:
      if any([i[0]==second_letter for i in words]) and any([i[1]==first_letter for i in words]):
            print("YES")
      else:
            print("NO")