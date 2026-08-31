# I believe the following algorithm should work.
# I will basically run two greedy algorithms and pick the one that does
# best.
# In each greedy algorithm, I will delete the largest element available.
# In the first, I will start with an odd element, in the other I will
# start with an even element.

def minimum_remaining_sum(lst):
  def greedy(lst, op_idx):
    while True:
      try:
        lst = ops[op_idx](lst)
        op_idx = (op_idx + 1) % 2
      except NoMatchingElementException:
        return lst

  rem_odd_start = sum(greedy(lst.copy(), 0))
  rem_even_start = sum(greedy(lst.copy(), 1))
  return min(rem_odd_start, rem_even_start)

def delete_odd(lst):
  for i in range(len(lst)):
    if lst[i] % 2 == 1:
      lst.pop(i)
      return lst
  raise NoMatchingElementException

def delete_even(lst):
  for i in range(len(lst)):
    if lst[i] % 2 == 0:
      lst.pop(i)
      return lst
  raise NoMatchingElementException

ops = [delete_odd, delete_even]

class NoMatchingElementException(Exception):
  pass

if __name__ == '__main__':
  _ = int(input())
  lst = sorted(map(int, input().split()), reverse=True)
  print(minimum_remaining_sum(lst))