from __future__ import absolute_import, division, print_function, unicode_literals
from typing import List
import sys
# **Note: To enable DEBUG, just add argument "-d" to the binary**. I.e.:
# `python solution.py -d`
DEBUG = len(sys.argv) > 1 and sys.argv[1] == '-d'


# Sample usage: `LOG("a =", 1,"b =", 2)`.
def LOG(*argv):
  if (DEBUG):
    print(*argv, file=sys.stderr)


def CHECK(cond, err_msg=''):
  if (DEBUG):
    assert cond, err_msg


def CHECK_EQ(a, b, err_msg=''):
  CHECK(a == b, err_msg='{} v.s. {} {}'.format(a, b, err_msg))


def readval(typ=int):
  return typ(input())


def readvals(typ=int):
  return map(typ, input().split())


###############################################################################/
############################* Above are tmpl code #############################/
###############################################################################/


def solve(arr: List[int]) -> int:
  pile1, pile2 = [], []
  for a in arr:
    if a % 2 == 0:
      pile1.append(a)
    else:
      pile2.append(a)
  if len(pile1) < len(pile2):
    pile1, pile2 = pile2, pile1
  LOG(pile1)
  LOG(pile2)
  # pile1 is always longer than pile2.
  if len(pile1) - len(pile2) <= 1:
    return 0
  pile1.sort(reverse=True)
  return sum(pile1[len(pile2)+1:])


if __name__ == '__main__':
  CHECK_EQ(solve([1, 2, 3]), 0)
  CHECK_EQ(solve([2, 3, 4, 4]), 2)
  CHECK_EQ(solve([4, 4, 4]), 8)
  CHECK_EQ(solve([4, 5]), 0)
  CHECK_EQ(solve([1, 5, 8, 7, 2]), 0)
  _ = readval()
  arr = readvals()
  print(solve(arr))