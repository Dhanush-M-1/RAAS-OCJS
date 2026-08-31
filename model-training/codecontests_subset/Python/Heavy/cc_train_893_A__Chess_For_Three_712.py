
class Solution(object):
    def __init__(self):
        self.solve()

    def next(self, type=int):
        temp = list(map(type, input().split()))
        return temp if len(temp) > 1 else temp[0]

    def solve(self):
        players = [1, 2, 3]
        for _ in range(self.next()):
            winner = self.next()

            if winner == players[0]:
                players.append(players.pop(1))
            elif winner == players[1]:
                players.append(players.pop(0))
            else:
                print('NO')
                break
        else:
            print('YES')


Solution()
