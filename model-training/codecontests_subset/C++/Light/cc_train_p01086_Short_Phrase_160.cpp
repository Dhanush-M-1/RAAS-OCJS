#include <algorithm>
#include <array>
#include <iostream>
#include <string>

std::string words[40];
const std::array<int, 5> N57577 = { 5, 7, 5, 7, 7 };

int main()
{
	while (true) {
		int n;
		std::cin >> n;

		if (n == 0) return 0;

		for (int i = 0; i < n; i++) {
			std::cin >> words[i];
		}

		for (int i = 0; i < n; i++) {
			int j = i;
			bool valid_tanka = true;

			for (int wn : N57577) {
				int count = 0;
				while (j < n) {
					count += words[j++].size();
					if (count >= wn) break;
				}
				if (count != wn) {
					valid_tanka = false;
					break;
				}
			}
			
			if (valid_tanka) {
				std::cout << (i + 1) << std::endl;
				break;
			}
		}
	}
}