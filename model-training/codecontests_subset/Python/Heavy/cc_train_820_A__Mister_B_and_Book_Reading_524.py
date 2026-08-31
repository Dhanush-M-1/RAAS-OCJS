import math

s = input()
arr = s.split()
totalPages = int(arr[0])
firstDayPages = int(arr[1])
maxPages = int(arr[2])
acceleration = int(arr[3])
reRead = int(arr[4])

readedPages = 0
day = 0

def getPagesOnDay(day):
  global firstDayPages, maxPages, acceleration, readedPages
  pages = firstDayPages + (day - 1) * acceleration
  
  if pages > maxPages:
    pages = maxPages

  if day > 1:
    pages = pages - reRead

  return pages


while True:
  day = day + 1
  readedPages = readedPages + getPagesOnDay(day)
  if readedPages >= totalPages:
    break

print(day)
