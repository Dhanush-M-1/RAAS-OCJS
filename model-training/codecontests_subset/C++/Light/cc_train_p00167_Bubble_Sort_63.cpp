#define _CRT_SECURE_NO_WARNINGS

#include<fstream>
#include<iostream>
#include<string>
#include<iomanip>
#include<list>
#include<math.h>
#include<stack>
#include<queue>
#include<vector>
#include<algorithm>
#include<utility>

using namespace std;

int main(int argc, char **argv){
	int n;
	while (cin >> n && n != 0){
		vector<int> v;
		for (int i = 0; i < n; i++) {
			int tmp;
			cin >> tmp;
			v.push_back(tmp);
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (v[j] > v[j + 1]) {
					swap(v[j], v[j + 1]);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}
	return 0;
}