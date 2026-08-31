import sys

t = int(input())


def analise(plays):
    play = plays.pop(0)
    if play[1] > play[0]:
        return "NO"

    for _ in range(len(plays)):
        if plays[0][1] > plays[0][0] or plays[0][0] < play[0] or plays[0][1] < play[1] or (plays[0][1] - play[1]) > (plays[0][0] - play[0]):
            return "NO"
        else:
            play = plays.pop(0)
    return "YES"



for i in range(t):
    n = int(input())
    plays = []
    for j in range(n):
        ax = input().split()
        plays.append((int(ax.pop(0)), int(ax.pop(0))))

    print(analise(plays))

					      	   	 	   	  		  		