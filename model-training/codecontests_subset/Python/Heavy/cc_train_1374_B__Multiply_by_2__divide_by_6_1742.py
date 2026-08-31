# WHERE: https://codeforces.com/problemset/page/4?order=BY_RATING_ASC

# 1
# Football
# https://codeforces.com/problemset/problem/96/A
# Input
# The first input line contains a non-empty string consisting of characters "0" and "1", which represents players. The length of the string does not exceed 100 characters. There's at least one player from each team present on the field.
# Output
# Print "YES" if the situation is dangerous. Otherwise, print "NO".

# listPlayers = input()
# currentTeam = 1

# for playerIndex in range(1, len(listPlayers)):
#     if currentTeam == 7:
#         break
#     if listPlayers[playerIndex - 1] == listPlayers[playerIndex]:
#         currentTeam += 1
#     else:
#         currentTeam = 1

# if currentTeam == 7:
#     print("YES")
# else:
#     print("NO")
# ---------------------------------------------------------------------------------------------------------------------

# 2
# Twins
# https://codeforces.com/problemset/problem/160/A
# Input
# The first line contains integer n (1 ≤ n ≤ 100) — the number of coins. The second line contains a sequence of n integers a1, a2, ..., an (1 ≤ ai ≤ 100) — the coins values. All numbers are separated with spaces.
# Output
# In the single line print the single number — the minimum needed number of coins.

# OTHER SOLUTION
# There is a better way to do it, sort the list, and add to my coins the until is greater than the sum of all the coins - the coins i removed

# def getIndexMaxNumber(listNumber):
#     maxIndex = 0
#     for i in range(1, len(listNumber)):
#         if listNumber[i] > listNumber[maxIndex]:
#             maxIndex = i
#     return maxIndex


# def getIndexLessNumber(listNumber):
#     lessIndex = 0
#     for i in range(1, len(listNumber)):
#         if listNumber[i] < listNumber[lessIndex]:
#             lessIndex = i
#     return lessIndex


# def sumCoins(listCoins):
#     sum = 0
#     for i in range(0, len(listCoins)):
#         sum += listCoins[i]
#     return sum


# numCoins = int(input())
# coins = list(map(int, input().split()))
# myCoins = []
# broCoins = []
# currentIndex = 0
# for i in range(numCoins):
#     maxCoinIndex = getIndexMaxNumber(coins)
#     lessCoinIndex = getIndexLessNumber(coins)
#     if sumCoins(myCoins) <= (sumCoins(broCoins) + coins[maxCoinIndex]):
#         myCoins.append(coins[maxCoinIndex])
#         del coins[maxCoinIndex]
#     else:
#         broCoins.append(coins[lessCoinIndex])
#         del coins[lessCoinIndex]
# print(len(myCoins))

# ---------------------------------------------------------------------------------------------------------------------

# 3
# HQ9+
# https://codeforces.com/problemset/problem/133/A
# Input
# The input will consist of a single line p which will give a program in HQ9+. String p will contain between 1 and 100 characters, inclusive. ASCII-code of each character of p will be between 33 (exclamation mark) and 126 (tilde), inclusive.
# Output
# Output "YES", if executing the program will produce any output, and "NO" otherwise.

# listPlayers = input()
# if "H" in listPlayers or "Q" in listPlayers or "9" in listPlayers:
#     print("YES")
# else:
#     print("NO")
# ---------------------------------------------------------------------------------------------------------------------

# 4
# Kefa and First Steps
# https://codeforces.com/problemset/problem/580/A
# Input
# The first line contains integer n (1 ≤ n ≤ 105).
# The second line contains n integers a1,  a2,  ...,  an (1 ≤ ai ≤ 109).
# Output
# Print a single integer — the length of the maximum non-decreasing subsegment of sequence a.

# cuantItems = int(input())
# itemsList = list(map(int, input().split()))

# maxSequenceCounter = 1
# prevMax = 1
# for idx in range(1, len(itemsList)):
#     if itemsList[idx - 1] <= itemsList[idx]:
#         maxSequenceCounter += 1
#     else:
#         maxSequenceCounter = 1
#     if prevMax < maxSequenceCounter:
#         prevMax = maxSequenceCounter
# print(prevMax)
# ---------------------------------------------------------------------------------------------------------------------

# 5
# Even Odds
# https://codeforces.com/problemset/problem/318/A
# Input
# The only line of input contains integers n and k (1 ≤ k ≤ n ≤ 1012).
# Please, do not use the %lld specifier to read or write 64-bit integers in C++. It is preferred to use the cin, cout streams or the %I64d specifier.
# Output
# Print the number that will stand at the position number k after Volodya's manipulations.

# inputFromUser = list(map(int, input().split()))
# maxNumber = inputFromUser[0]
# n = inputFromUser[1]
# number = 0
# if maxNumber % 2 == 0:
#     if n <= maxNumber//2:
#         number = 2*n - 1
#     else:
#         number = 2*n - maxNumber
# else:
#     if n <= (maxNumber - (maxNumber // 2)):
#         number = 2*n - 1
#     else:
#         number = 2*n - maxNumber - 1
# print(number)

# ---------------------------------------------------------------------------------------------------------------------

# 6
# Gravity Flip
# https://codeforces.com/problemset/problem/405/A

# counter = input()
# cols = list(map(int, input().split(" ")))
# cols.sort()
# answer = str(cols[0])
# for idx in range(1, len(cols)):
#     answer += " " + str(cols[idx])
# print(answer)

# ---------------------------------------------------------------------------------------------------------------------

# 7
# userEntry = list(map(int, input().split()))
# students = userEntry[0]
# puzzels = userEntry[1]

# puzzelsList = list(map(int, input().split()))
# puzzelsList.sort()
# times = puzzels - students + 1
# smallerDif = -1
# for time in range(times):
#     actualDif = abs(puzzelsList[time] - puzzelsList[time + (students - 1)])

#     if actualDif < smallerDif or smallerDif == -1:

#         smallerDif = actualDif
# print(smallerDif)
# ---------------------------------------------------------------------------------------------------------------------
# 8
# Dubstep
# https://codeforces.com/problemset/problem/208/A
# Input
# The input consists of a single non-empty string, consisting only of uppercase English letters, the string's length doesn't exceed 200 characters. It is guaranteed that before Vasya remixed the song, no word contained substring "WUB" in it; Vasya didn't change the word order. It is also guaranteed that initially the song had at least one word.
# Output
# Print the words of the initial song that Vasya used to make a dubsteb remix. Separate the words with a space.
# userEntry = input().split("WUB")
# original = ""
# for word in userEntry:
#     if word != "":
#         if original == "":
#             original = word
#         else:
#             original += " " + word
# print(original)
# ---------------------------------------------------------------------------------------------------------------------

times = int(input())
answers = []
for time in range(times):
    currentNumber = int(input())
    if currentNumber == 1:
        answers.append(0)
    else:
        moves = 0
        while currentNumber != 2:
            if currentNumber / 6 == 1:
                moves += 1
                break
            elif currentNumber % 3 != 0:
                moves = -1
                break
            else:
                if currentNumber % 6 == 0:
                    currentNumber = currentNumber / 6
                else:
                    currentNumber = currentNumber * 2
            moves += 1
        if currentNumber == 2:
            moves = -1
        answers.append(moves)

for i in range(len(answers)):
    print(answers[i])
