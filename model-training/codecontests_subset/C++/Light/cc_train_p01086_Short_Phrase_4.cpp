#include<iostream>
#include<string>
using namespace std;
int main() {
	int n;
	const int sp[] = { 5,7,5,7,7 };
	while (cin >> n, n){
		int a[41];
		for (int i = 0; i < n; i++) {
			string s; cin >> s;
			a[i] = s.size();
		}
		for (int i = 0; i < n; i++) {
			int cnt = 0, k = 0;
			for (int j = 0;; j++) {
				cnt += a[i + j];
				if (cnt == sp[k]) {
					k++;
					if (k == 5) {
						cout << i + 1 << endl;
						goto end;
					}
					cnt = 0;
				}
				else if (cnt > sp[k])break;
			}
		}
	end:;
	}
}