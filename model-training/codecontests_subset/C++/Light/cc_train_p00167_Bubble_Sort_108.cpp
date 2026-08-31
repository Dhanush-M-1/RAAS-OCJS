#include <iostream>
#include <vector>
using namespace std;

int main(void){
	while(1){
		int n; cin >> n;
		if(n == 0)return 0;

		vector<int> v;
		for (int i = 0; i < n; ++i){
			int t; cin >> t;
			v.push_back(t);
		}

		int cnt = 0;
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n - i - 1; ++j){
				if(v[j] > v[j + 1]){
					swap(v[j], v[j + 1]);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}
}