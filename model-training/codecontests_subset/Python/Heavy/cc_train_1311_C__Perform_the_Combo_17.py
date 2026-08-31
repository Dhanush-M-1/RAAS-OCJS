
import collections

class Solution:
    # Total Brute Force
    def solve(self, n, m, string, p):
        counts = [0 for _ in range(26)]

        for num in p:
            for i in range(num):
                counts[ord(string[i]) - ord('a')] += 1

        for ch in string:
            counts[ord(ch) - ord('a')] += 1

        return " ".join(map(str, counts))

    # def solveWithSet(self, n, m, string, p):
    #     counts = [0 for _ in range(26)]

    #     pSet = collections.Counter(p)

    #     for num, count in pSet.items():
    #         for i in range(num):
    #             counts[ord(string[i]) - ord('a')] += count

    #     for ch in string:
    #         counts[ord(ch) - ord('a')] += 1

    #     return " ".join(map(str, counts))

    def solveWithPrefixSums(self, n, m, string, p):
        counts = [0 for _ in range(26)]
        prefixSums = [0 for _ in range(n)]

        prefixSums[n-1] += 1

        for num in p:
            prefixSums[num-1] += 1

        for i in range(n-1, 0, -1):
            prefixSums[i-1] += prefixSums[i]

        for i in range(n):
            counts[ord(string[i]) - ord('a')] += prefixSums[i]

        return " ".join(map(str, counts))

sol = Solution()

t = int(input().strip())

for i in range(t):
    [n, m] = list(map(int, input().strip().split()))

    string = input().strip()
    p = list(map(int, input().strip().split()))

    print(sol.solveWithPrefixSums(n, m, string, p))