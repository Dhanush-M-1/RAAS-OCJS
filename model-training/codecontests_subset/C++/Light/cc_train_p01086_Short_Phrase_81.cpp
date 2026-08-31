#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(void) {
	int n;
	int tan[5] = {5,7,5,7,7};
	cin >> n;
	while (n != 0) {
		vector<string> str(n);
		for (int i = 0; i < n; ++i) {
			cin >> str[i];
		}
		bool find = false;
		bool over = false;
		int ind = 0;
		int ln = 0;
		int ret;
		for (int i = 0; !find && i < n; ++i) {
			over = false;
			ind = 0;
			ln = 0;
			for (int j = i; !over && j < n; ++j) {
				if (ln + str[j].length() == tan[ind]) {
					if (ind == 4) {
						find = true;
						ret = i+1;
					}
					else {
						++ind;
						ln = 0;
					}
				}
				else if (ln + str[j].length() < tan[ind]) {
					ln += str[j].length();
				}
				else {
					over = true;
				}
			}
		}
		cout << ret << endl;
		cin >> n;
	}
	return 0;
}