#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
#include<string>
#include<tuple>
#include<utility>
#include<stack>
#include<set>
#include<iomanip>
using namespace std;
using ll=long long int;

int main() {

	int n;
	while (cin >> n) {
		vector<int>a(n);
		for (int i = 0; i < n; i++)cin >> a[i];

		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (abs(a[i] - a[j]) % (n - 1) == 0) {
					cout << a[i] << " " << a[j] << endl;
					return 0;
				}
			}
		}
	}

	return 0;
}

