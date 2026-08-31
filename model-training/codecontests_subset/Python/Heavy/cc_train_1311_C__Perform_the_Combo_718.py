# Input: 'abcdeabc', [2, 5]
# Out: {a: 4, b: 4, c: 3, d: 2, e: 2}

def get_step_counts(combo):
  step_counts = []
  step_count = [0] * 26
  step_counts.append(step_count[:])

  for letter in combo:
    idx_in_array = ord(letter) - ord('a')
    step_count[idx_in_array] += 1
    step_counts.append(step_count[:])

  return step_counts

def combo_count(combo, mistakes): # 'abc', [2]
  step_counts = get_step_counts(combo) # [[...], [1, ...], [1, 1, ...], [1, 1, 1, ...]]
  
  counts = [0] * 26 
  for mistake in mistakes + [len(combo)]: # 2 -> 3
    for idx, item in enumerate(step_counts[mistake]):
      counts[idx] += item # [2, 2, 1, ...]

  return counts

test_number = int(input())

for _ in range(test_number):
  input()
  combo = input()
  mistakes = [int(x) for x in input().split()]
  result = combo_count(combo, mistakes)
  print(' '.join([str(x) for x in result]))

# 'abc', [2] -> [2, 2, 1, 0, 0, ...]

# n - combo size
# m - number of mistakes
# A - 26
# time: O(A*(n+m))
# memory: O(A*n)

# 'a', [] -> [1, ...]
# 'ab', [1] -> [2, 1, ...]
# 'abca', [3] -> [3, 2, 2, ...]
# 'ab', [1, 1] -> [3, 1]

