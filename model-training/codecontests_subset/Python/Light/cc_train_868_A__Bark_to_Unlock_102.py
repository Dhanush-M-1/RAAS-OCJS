password = str(input())
number_of_barks = int(input())
all_the_barks = []
for i in range (number_of_barks):
  all_the_barks.append(str(input()))
yes = False

for bark in all_the_barks:
  for next_bark in all_the_barks:
    if password in bark + next_bark:
      yes = True

if yes == True:
  print("YES")
else:
  print("NO")
  