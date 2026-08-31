import sys
no_of_prizes = int(sys.stdin.readline().rstrip("\n"))
positions = sys.stdin.readline().rstrip("\n")
positions = positions.split(" ")
positions = [int(pos) for pos in positions]

my_prizes = [i for i in positions if i<=500000]
friend_prizes = [i for i in positions if i>500000]

if len(my_prizes)>0:
    furthest_prize_me = max(my_prizes)
    furthest_time_taken_me = furthest_prize_me-1
else:
    furthest_time_taken_me  = 0

if len(friend_prizes)>0:
    furthest_prize_friend = min(friend_prizes)
    furthest_time_taken_friend = 10**6 - furthest_prize_friend
else:
    furthest_time_taken_friend = 0
print(max(furthest_time_taken_me,furthest_time_taken_friend))
