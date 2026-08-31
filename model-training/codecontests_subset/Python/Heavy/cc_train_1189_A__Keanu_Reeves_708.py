from typing import List


class Solution:


    def matrix(self, s):

        if len(s) == 1:
            print('1\n' + s)
        else:
            one = 0
            cero = 0
            for i in s:
                if i == '1':
                    one += 1
                else:
                    cero += 1
            if cero == one:
                print(2)
                print(s[0] + ' ' + s[1:])
            else:
                print(1)
                print(s)


sol = Solution()
size = int(input())
s = input()
sol.matrix(s)
