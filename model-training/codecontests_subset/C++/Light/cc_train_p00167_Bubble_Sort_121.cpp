#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {
	int n;
	while (cin >> n){
		if (n == 0)return 0;
		int l[101];
		int sum = 0;
		for (int i = 0; i < n; i++){
			int a; cin >> a;
			l[i] = a;
		}
		for (int i = n; i > 0; i--){
			for (int j = 0; j < n - 1; j++) {
				if (l[j] > l[j + 1]){
					swap(l[j], l[j + 1]);
					sum++;
				}
			}
		}
		cout << sum << endl;
	}
}