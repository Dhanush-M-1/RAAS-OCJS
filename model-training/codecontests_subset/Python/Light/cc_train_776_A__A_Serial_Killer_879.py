first_day = list(map(str, input().split(" ")))
days = int(input())
print ("%s %s" % (first_day[0], first_day[1]))
for x in range(days):
    new_names = list(map(str, input().split(" ")))
    first_day[first_day.index(new_names[0])] = new_names[1]
    print ("%s %s" % (first_day[0], first_day[1]))
