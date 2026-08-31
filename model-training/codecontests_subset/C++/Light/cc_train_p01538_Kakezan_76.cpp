#include <iostream>
#include <algorithm>
#include <string>

int q;
std::string str, b, e;

int solve(int m) {
	int cnt = 0;
	while (1) {
		str = std::to_string(m);
		if (str.size() == 1)
			break;
		b.clear();
		e = str;
		int l, r, max = 0;
		for (int i = 0; i < str.size() - 1; ++i) {
			b += str[i];
			e.erase(e.begin());
			l = std::stoi(b);
			r = std::stoi(e);
			max = std::max(max, l*r);
			m = max;
		}
		++cnt;
	}
	return cnt;
}

int main() {
	std::cin >> q;
	int n;
	for (int i = 0; i < q; ++i) {
		std::cin >> n;
		std::cout << solve(n) << std::endl;
	}
	return 0;
}