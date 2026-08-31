#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;

int main() {
	int n;

	while (cin >> n,n	)
	{

		vector<string> w;
		for (int i = 0;i < n;++i) {
			string tmp;
			cin >> tmp;
			w.push_back(tmp);
		}

		int flag = 0;
		int len = 0;
		int output = 100000000;
		for (int i = 0;i < n;++i) {
			flag = 0;
			len = 0;
			for (int j = i; j< n;++j) {
				len += w[j].size();
				if (flag == 0 || flag == 2) {
					if (len == 5) {
						len = 0;
						flag++;
					}
					else if (len > 5) {
						break;
					}
				}
				else {
					if (len == 7) {
						len = 0;
						flag++;
					}
					else if (len > 7) {
						break;
					}
				}
			}

			if (flag >= 5) {
				output = i + 1;
				break;
			}
		}

		cout << output << endl;
	}


}