#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
	int tanku[5] = { 5,7,5,7,7 };

	while (true) {
		int n;
		cin >> n;

		if (n == 0) {
			break;
		}

		vector<string> strings(n);

		for (int i = 0; i < n; i++) {
			cin >> strings[i];
		}

		int ans;

		for (int i = 0; i < n; i++) {
			bool flag = true;
			int cur = 0;
			int size = 0;

			for (int j = i; j < n; j++) {
				size += strings[j].size();

				if (size > tanku[cur]) {
					flag = false;
					break;
				}

				if (size == tanku[cur]) {
					cur++;
					size = 0;
					if (cur == 5) {
						break;
					}
				}
			}

			if (flag == true) {
				ans = i + 1;
				break;
			}
		}

		cout << ans << endl;
	}

	return 0;
}