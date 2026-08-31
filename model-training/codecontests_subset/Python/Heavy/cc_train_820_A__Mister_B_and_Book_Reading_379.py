# http://codeforces.com/problemset/problem/820/A

"""
get inputs and assign to variables
"""
inputs = [int(x) for x in input().split(' ')]

book_pages = inputs[0]
init_speed = inputs[1]
maxi_speed = inputs[2]
accelerate = inputs[3]
re_reading = inputs[4]

days = 0
pages_read = 0

# might not need this override section after you adjusted "while" statement
override = False

if book_pages / init_speed <= 1:
    override = True

while pages_read < book_pages:
    # if pages_read == 0 then you aren't re-reading anything
    if pages_read == 0:
        pages_read += init_speed
    else:
        pages_read += init_speed - re_reading
    # init speed can't be greater than max speed
    init_speed = min(init_speed + accelerate, maxi_speed)
    days += 1

# might not need this override section after fixing 'while'
if override:
    print(1)
else:
    print(days)
