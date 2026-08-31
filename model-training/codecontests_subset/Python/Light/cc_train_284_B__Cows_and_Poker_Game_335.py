nb_cows = int(input())
status  = input()
icount  = status.count("I")
if icount == 1:
    print(1)
elif icount > 1:
    print(0)
else:
    print(status.count("A"))