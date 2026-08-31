# -*- coding: utf-8 -*-
"""
Created on Tue Jan 28 11:51:27 2020

@author: ASUS
"""

# Python program for implementation of Insertion Sort

# Function to do insertion sort
def insertionSort(arr):

	# Traverse through 1 to len(arr)
	for i in range(1, len(arr)):

		key = arr[i]

		# Move elements of arr[0..i-1], that are
		# greater than key, to one position ahead
		# of their current position
		j = i-1
		while j >= 0 and key < arr[j] :
				arr[j + 1] = arr[j]
				j -= 1
		arr[j + 1] = key





str =input()
str2 = str.split("+")
insertionSort(str2)

out = "+".join(str2)
print(out)