n = int(input())
a = str(input())
count = 0
for item in a:
  if item == "8":
    count += 1
print(int(min(n/11, count)))