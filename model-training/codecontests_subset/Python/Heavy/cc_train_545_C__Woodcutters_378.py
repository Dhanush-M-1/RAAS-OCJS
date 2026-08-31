# print ("Input n")
n = int(input())

x = []
h = []
for i in range(n):
    # print ("Input the next x/h pair")
    thepair = input().split()
    x.append(int(thepair[0]))
    h.append(int(thepair[1]))

answer = 2    # First one can always go left, last one right
rightx = -1   # To remember where the previous one is, if it went right
for i in range(1,n-1):
    thex = x[i]
    theh = h[i]
    if (rightx > -1):
        prevx = rightx
    else:
        prevx = x[i-1]
    if (thex - theh > prevx):   #  It can go left
        answer = answer + 1
        rightx = -1
    elif (thex + theh < x[i+1]):  #  It can go right
        answer = answer + 1
        rightx = thex + theh
    else:    #  Neither way works--set rightx back to -1 here!
        rightx = -1

if (n==1):    # Special case with one tree!
    print(1)
else:
    print (answer)
        
