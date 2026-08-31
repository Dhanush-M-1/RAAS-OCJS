#include<iostream>
using namespace std;
int main() {
	int l[110], n; cin >> n;
	for (int i = 0; i < n; i++){
		cin >> l[i];
	}
	int sum = 0;
	for (int i = 0; i < n; i++){
		int minj = i;
		for (int j = i; j < n; j++) {
			if (l[j] < l[minj])minj = j;
		}
		if (i != minj){
			int tmp = l[i];
			l[i] = l[minj];
			l[minj] = tmp;
			sum++;
		}
	}
	for (int i = 0; i < n; i++){
		cout << l[i];
		if (i != n - 1)cout << ' ';
		else cout << endl << sum << endl;
	}
	return 0;
}