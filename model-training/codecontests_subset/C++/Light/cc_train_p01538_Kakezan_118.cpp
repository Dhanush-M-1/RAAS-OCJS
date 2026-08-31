#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;

	cin >> n;

	for (int i = 0; i < n; i++) {
		int value, source_value, count = 0;

		cin >> source_value;
		value = source_value;

		while (value >= 10) {
			count++;

			string str = to_string(value);
			int len = str.size(), max = 0;

			for (int j = 1; j < len; j++) {
				int temp1, temp2;

				temp1 = stoi(str.substr(0, j));
				temp2 = stoi(str.substr(j));

				if (max < temp1 * temp2) {
					max = temp1 * temp2;
				}
			}

			value = max;
		}

		cout << count << endl;
	}

	return 0;
}