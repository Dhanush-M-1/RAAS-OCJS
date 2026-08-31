#include <iostream>
#include <vector>
#include <string>

int solve(const std::vector<int>& ls) {
	int cs[] = { 5, 12, 17, 24, 31 };
	for (int i = 0; i < ls.size(); i++) {
		int c = 0;
		int l = 0;
		for (int j = i; j < ls.size(); j++) {
			l += ls.at(j);
			if (cs[c] == l) {
				c++;

				if (c >= 5) {
					return i+1;
				}
			}
			else if (cs[c] < l) {
				break;
			}
		}
	}
	return -1;
}

int main()
{
	while (true)
	{
		int n;
		std::cin >> n;
		if (n == 0) {
			break;
		}

		std::vector<int>ws;
		ws.resize(n);

		for (int i = 0; i < n; i++) {
			std::string s;
			std::cin >> s;
			ws.at(i) = s.size();
		}

		std::cout << solve(ws) << std::endl;


	}
}