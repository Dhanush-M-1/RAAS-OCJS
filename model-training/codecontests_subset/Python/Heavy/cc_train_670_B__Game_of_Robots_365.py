initialInputSeparated = input().split(" ")

numberOfRobots = int(initialInputSeparated[0])
positionToIdentify = int(initialInputSeparated[1])
robotIdentifiersOrdered = input().split(" ")
pronouncingPositionsOrdered = []

pronouncedPositionsTotal = 1
lastRobotPronounced = 1
while pronouncedPositionsTotal < positionToIdentify:
    pronouncedPositionsTotal += lastRobotPronounced + 1
    lastRobotPronounced += 1

inversePositionInLastRobotPronounced = pronouncedPositionsTotal - positionToIdentify
positionIdentified = list(range(lastRobotPronounced - 1, -1, -1))[inversePositionInLastRobotPronounced]
identifierAsked = robotIdentifiersOrdered[positionIdentified]

print(identifierAsked)

   	 				 	 	   			  	 			   		