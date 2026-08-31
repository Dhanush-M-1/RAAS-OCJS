dic = {}
base = ord("a")
for x in range(5):
  for y in range(5):
    dic[(x + 1, y + 1)] = chr(base + x * 5 + y)
dic[(6, 1)] = "z"
dic[(6, 2)] = "."
dic[(6, 3)] = "?"
dic[(6, 4)] = "!"
dic[(6, 5)] = " "

def to_mess(nums):
  if len(nums) % 2 == 1:
    return "NA"
  
  mess = ""
  for i in range(0, len(nums), 2):
    x, y = map(int, nums[i: i + 2])
    if (x, y) in dic:
      mess += dic[(x, y)]
    else:
      return "NA"

  return mess

while True:
  try:
    nums = input()
    print(to_mess(nums))
  except EOFError:
    break
