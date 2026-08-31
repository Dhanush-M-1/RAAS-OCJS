"""
Codeforces
7B - Memory Manager
http://codeforces.com/contest/7/problem/B

Héctor González Belver
../07/2018
"""
import sys

def main():
  t, m = map(int, sys.stdin.readline().strip().split())

  memory = [0] * m

  block_number = 0

  def allocate(num_bytes):
    nonlocal block_number
    hi = -1
    allocated = False
    while not allocated:
      try:
        lo = memory.index(0, hi+1)
      except ValueError:
        break
      hi = lo + num_bytes - 1
      if hi >= m:
        break
      allocated = True
      for i, mem in enumerate(memory[lo:hi+1]):
        if mem:
          hi = lo + i
          allocated = False
          break

    if not allocated:
        sys.stdout.write('NULL' + '\n')
    else:
      block_number += 1
      for i in range(num_bytes):
        memory[lo+i] = block_number
      sys.stdout.write(str(block_number) + '\n')

  def erase(block):
    try:
      if block <= 0:
        raise ValueError
      idx = memory.index(block)
    except ValueError:
      sys.stdout.write('ILLEGAL_ERASE_ARGUMENT' + '\n')
    else:
      while idx < m and memory[idx] == block:
        memory[idx] = 0
        idx += 1

  def defragmentate():
    nonlocal memory
    memory = [byte for byte in memory if byte]
    memory += [0] * (m - len(memory))

  for i in range(t):
    operation = sys.stdin.readline().strip().split()
    if operation[0] == 'alloc':
      allocate(int(operation[1]))
    elif operation[0] == 'erase':
      erase(int(operation[1]))
    elif operation[0] == 'defragment':
      defragmentate()

    
if __name__ == '__main__': 
  main()