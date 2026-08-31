"""
Cyclic Permutation

The answer is n! − 2^(n−1)

.

Consider an arbitrary cyclic permutation — for example, [4,2,3,1,5,6]; it contains many cycles of length 3
: [1,2,3], [1,3,5], [3,4,5]. Note that all the listed cycles contain nodes obtained from just one choice of i. We can generalize this to the following. If for any i, we make edges on both sides of it, this will create a simple cycle of length 3

. The proof is simple and is an exercise for you.

Thus, there has to at most one peak that is the element n
– all acyclic permutations increase, then reach n, and, finally, decrease. These are formally called unimodal permutations, and it's easy to see that any unimodal permutation forms a tree, and, thus, contains no simple cycle  — each element, except n

, has a uniquely defined parent.

We can construct any unimodal permutation by adding the numbers n,n−1,…,1
into a deque in the same order. For example, [2,3,4,1] can be constructed by first pushing 4, 3, 2 to the front, and, finally, 1 at the back. Thus, for every element, except n, we have the choice of pushing it to the front or the back, making the total number of ways equal to 2^(n−1)

.

Time Complexity: O(n)
"""

import sys
read = lambda: sys.stdin.readline().strip()

n = int(read())
MOD = 1e9 + 7
fact = 1
two_pow = 1
for i in range(2, n+1):
    fact = (i * fact) % MOD
    two_pow = (2 * two_pow) % MOD

print(int(int(fact - two_pow) % MOD))