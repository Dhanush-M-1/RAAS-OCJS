string_len = int(input())

string = input()

string_thresh = 0

capital_dict = []
capital_count = []


def add_capital(letter, capital_dict, capital_count):
    capital_dict.append(letter)
    capital_count.append(1)


def check_capital(letter_a, letter_b, capital_dict, capital_count):
    letter = letter_a + letter_b
    try:
        letter_idx = capital_dict.index(letter)
        capital_count[letter_idx] += 1
    except ValueError:
        add_capital(letter, capital_dict, capital_count)


while string_thresh < (string_len - 1):
    check_capital(string[string_thresh], string[string_thresh + 1], capital_dict, capital_count)
    string_thresh += 1

max_value_idx = capital_count.index(max(capital_count))
print(capital_dict[max_value_idx])

	    	 	 	  		   	    				  	 	